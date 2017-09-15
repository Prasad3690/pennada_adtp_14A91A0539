import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException();
		else
			this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if((index<0)||(index>=students.length))
			throw new IllegalArgumentException();
		else
			return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if((student==null)||(index<0)||(index>=students.length))
			throw new IllegalArgumentException();
		else
			this.students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length+1];
			temp[0]=student;
			for(int i=0;i<students.length;i++){
				temp[i+1]=students[i];
			}
			students=temp;
		}		
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length+1];
			int i;
			for(i=0;i<students.length;i++){
				temp[i]=students[i];
			}
			temp[i]=student;
			students=temp;
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if((student==null)||(index<0)||(index>=students.length))
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length+1];
			for(int i=0;i<students.length;i++){
				if(index==i)
					temp[i]=student;
				if(i<=index)
					temp[i+1]=students[i];
				else
					temp[i]=students[i];
			}
			students=temp;
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if((index<0)||(index>=students.length))
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length-1];
			for(int i=0;i<students.length;i++){
				if(i<=index)
					temp[i]=students[i];
				else
					temp[i-1]=students[i];
			}
			students=temp;
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length-1];
			int f=0;
			for(int i=0;i<students.length;i++){
				if(f==0)
					temp[i]=students[i];
				else
					temp[i-1]=students[i];
				if(students[i]==student)
					f=1;
			}
			students=temp;
			if(f==0)
				throw new IllegalArgumentException("Student Not Exist");
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if((index<0)||(index>=students.length))
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length];
			for(int i=0;i<students.length;i++){
				if(i<=index){
					temp[i]=students[i];
					break;
				}
			}
			students=temp;
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length];
			int f=0;
			for(int i=0;i<students.length;i++){
				if(f==0)
					temp[i]=students[i];
				if(students[i]==student)
					f=1;
			}
			students=temp;
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if((index<0)||(index>=students.length))
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length];
			int j=0;
			for(int i=0;i<students.length;i++){
				if(i<index)
					continue;
				temp[j++]=students[i];
			}
			students=temp;
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length];
			int f=0,j=0;
			for(int i=0;i<students.length;i++){
				if(students[i]==student)
					f=1;
				if(f==1)
					temp[j++]=students[i];
			}
			students=temp;
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<students.length;i++){
			for(int j=0;j<students.length-i;j++){
				if(students[j].getId()>students[j+1].getId()){
					Student temp;
					temp=students[j+1];
					students[j+1]=students[j];
					students[j]=temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date==null)
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length];
			int j=0;
			for(int i=0;i<students.length;i++){
				if(!students[i].getBirthDate().after(date))
					temp[j++]=students[i];
			}
			return temp;
		}
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if((firstDate==null)||(lastDate==null))
			throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[students.length];
			int j=0;
			for(int i=0;i<students.length;i++){
				if((students[i].getBirthDate().after(firstDate))&&(students[i].getBirthDate().before(lastDate)))
					temp[j++]=students[i];
			}
			return temp;
		}
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		if(date==null)
			throw new IllegalArgumentException();
		else{
			long t1=date.getTime()+days*24*60*60*1000;
			Date t2=new Date(t1);
			Student[] temp=new Student[students.length];
			int j=0;
			for(int i=0;i<students.length;i++){
				if((students[i].getBirthDate().equals(date))||(students[i].getBirthDate().after(t2)))
					temp[j++]=students[i];
			}
			return temp;
		}
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent==0)
			throw new IllegalArgumentException();
		else{
			Date now =new Date();
			long nowT=now.getTime();
			return (int)(nowT-students[indexOfStudent].getBirthDate().getTime())/(365*24*60*60*1000);
		}
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		Student[] temp=new Student[students.length];
		Date now =new Date();
		long nowT=now.getTime();
		int j=0;
		for(int i=0;i<students.length;i++){
			if(age==(nowT-students[i].getBirthDate().getTime())/(365*24*60*60*1000))
				temp[j++]=students[i];
		}
		return temp;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		Student[] temp=new Student[students.length];
		int j=0;
		double max=0;
		for(int i=0;i<students.length;i++){
			if(max<students[i].getAvgMark())
				max=students[i].getAvgMark();
		}
		for(int i=0;i<students.length;i++){
			if(max==students[i].getAvgMark())
			temp[j++]=students[i];
		}
		return temp;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			int f=0;
			for(int i=0;i<students.length;i++){
				if(f==1)
					return students[i];
				if(students[i]==student)
					f=1;
			}
			return null;
		}
	}
}
