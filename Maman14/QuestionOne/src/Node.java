public class Node <E>{
    private E nodeContent;
    private E next;

    public Node (E nodeContent) {
        this.nodeContent = nodeContent;
        this.next = null;       
        
    }
    public Node (E nodeContent, E next) {
        this.nodeContent = nodeContent;
        this.next = next;       
    }


    /*
     * שדה מטיפוס ג
- שדה המשמש כמצביע לתא הבא ברשימה.
.null אי ליצירת תא, המקבל את תוכן התא ויוצר תא עם התוכן הרצוי ומצביע  - ב
אי ליצירת תא, המקבל את תוכן התא ומצביע לתא הבא ויוצר את התא המבוקש.  - ב
לעדכון והחזרת תוכן התא. get- ו set - מתודות
לעדכון והחזרת המצביע לתא הבא. get- ו set - מתודות
     */

}
