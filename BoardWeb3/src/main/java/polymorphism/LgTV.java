package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("tv")
public class LgTV implements TV {
	
/*	@Autowired
	@Qualifier("apple")*/
	@Resource(name = "sony")
	private Speaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println("===> LgTV(1) 객체 생성됨");
	}
	
	public LgTV(Speaker speaker) {
		System.out.println("===> LgTV(2) 객체 생성됨");
	}
	
	public LgTV(Speaker speaker, int price) {
		System.out.println("===> LgTV(3) 객체 생성됨");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("LgTV --- 전원을 켠다.");
	}

	public void powerOff() {
		System.out.println("LgTV --- 전원을 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}