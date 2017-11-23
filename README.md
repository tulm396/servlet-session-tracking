# Java Session Management
- Đầu tiên, HTTP protocol và Web Server là "phi trạng thái" (stateless). Vậy thì stateless và stateful là gì? Sau đây, tôi sẽ trình bày khái niệm về stateless và stateful.
	- Stateless là một thiết kế mà server không lưu dữ liệu của client. Nghĩa là sau khi client gửi và nhận dữ liệu từ server thì client và server sẽ không dính dáng gì với nhau hết.
	- Stateful là thiết kế ngược lại với stateless, nghĩa là server sẽ lưu lại dữ liệu của client, ràn buộc giữ client và server sẽ vẫn được giữ sau mỗi request của client. Tuy nhiên, một vài trường hợp là cần phải lưu lại thông tin của client ví dụ như: thêm hàng vào giỏ hàng.
- Session là một chuyển đổi trạng thái (conversional state - không biết dịch đúng không?) giữa client và server và nó có thể bao gồm nhiều request và response giữ client và server. Trong khi HTTP protocol và Web Server là "phi trạng thái", do đó, cách duy nhất để duy trì cái session này là trong mỗi request hoặc response, chúng ta sẽ đặt session id (những thành phần có thể phân biệt các session, không hẳn phải là session id) vào.

## 1 Cookies
- Cookie có 2 loại:
	- Cookie không liên tục: có giá trị trong 1 session. Bị xóa khi client tắt trình duyệt
	- Cookie liên tục: có giá trị cho nhiều session. Session chỉ bị xóa khi client Login và Logout
- Ưu điểm khi dùng cookies:
	- Kỹ thuật đơn giản nhất để duy trì trạng thái
	- Cookies được duy trì tại client
- Nhược điểm của cookies:
	- Không hoạt động nếu client tắt cookie
	- Chỉ có thể đặt text trong cookie
## 2 Hidden form field
- Thường dùng thẻ input ẩn để lưu
- Ưu điểm của hidden form field:
	- Nó luôn hoạt động cho dù người dùng có bật cookie hay không
- Nhược điểm của hidden form field
	- Duy trì bên phía server
	- Yêu cầu sumbit form trên mỗi trang
	- Chỉ lưu được dữ liệu text
## 3 URL rewriting
- Kỹ thuật này sẽ truyền dữ liệu qua đường link theo định dạng:
- url?name1=value&name2=value
- Ưu điểm của URL rewriting:
	- Luôn hoạt động cho dù chức năng cookie có bật hay không
	- Không yêu cầu mỗi trang phải có sumbit form
- Nhược điểm của URL rewriting
	- Chỉ hoạt động với link
	- Chỉ gửi được dữ liệu text
## 4 HttpSession
- Thùng chứa sẽ tạo một  session id cho mỗi user. Thùng chứa sẽ dùng cái id đó để nhận diện user. Một đối tượng HttpServer có thể được sử dụng để:
	- Ràng buộc đối tượng
	- Xem và sử dụng thông tin về session, như là session id, thời gian khởi tạo và thời gian truy cập cuối cùng
- Làm sao để lấy được đối tượng HttpSession:
	- public HttpSession getSession(): lấy session hiện tại trong request , nếu không có, tạo một cái và trả về
- Một số phương thức của HttpSession:
	- public String getId(): lấy id của session
	- public long getCreationTime(): lấy thời điểm khởi tạo của session
	- public long getLastAccessedTable(): trả về thời gian cuối cùng mà client tưởng tác với user
	- public void invalidate(): hủy session và bỏ những ràng buộc với nó

