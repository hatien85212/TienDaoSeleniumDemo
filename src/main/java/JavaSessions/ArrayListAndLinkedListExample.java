package JavaSessions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedListExample {
//	1. Cơ Chế Lưu Trữ
//	ArrayList: Sử dụng một mảng động để lưu trữ các phần tử. Điều này có nghĩa rằng nó có thể thực hiện các thao tác truy cập một cách nhanh chóng. Tuy nhiên, nếu bạn xoá một phần tử khỏi mảng, toàn bộ các phần tử sau nó phải được di chuyển trong bộ nhớ để đảm bảo thứ tự không bị thay đổi.
//	LinkedList: Sử dụng danh sách liên kết đôi để lưu trữ các phần tử. Thao tác với LinkedList nhanh hơn so với ArrayList vì khi xoá hoặc chèn một phần tử, chỉ cần điều chỉnh các liên kết giữa các nút trong danh sách liên kết, không cần di chuyển dữ liệu trong bộ nhớ.
//	2. Sử Dụng
//	ArrayList: Thích hợp cho việc lưu trữ và truy cập dữ liệu khi bạn cần nhanh chóng truy cập các phần tử theo chỉ số. Ví dụ: danh sách điểm của một lớp học.
//	LinkedList: Thích hợp cho các thao tác thêm/xoá dữ liệu thường xuyên, chẳng hạn như danh sách cuộc gọi hoặc hàng đợi (queue) với việc thêm/xoá phần tử ở cả hai đầu. Nó cũng là lựa chọn tốt cho việc duyệt danh sách theo cách lùi.
	public static void main(String args[]) {
        // Tạo ArrayList
        List<String> arrayList = new ArrayList<String>();
        // Thêm phần tử vào ArrayList
        arrayList.add("Java");
        arrayList.add("C++");
        arrayList.add("PHP");
        arrayList.add("Python");
        
        // Tạo LinkedList
        List<String> linkedList = new LinkedList<String>();
        // Thêm phần tử vào LinkedList
        linkedList.add("Hibernate");
        linkedList.add("Struts2");
        linkedList.add("Spring");
        linkedList.add("Mybatis");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }

}
