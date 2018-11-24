package File_format;

public class CsvLine {

	
	// I create this class for represent every line at the csv file
	
	
	private String type;
	private int AccuracyMeters;
	private double AltitudeMeters;
	private double CurrentLongitude;
	private double CurrentLatitude;
	private int RSSI;
	private int Channel;
	private String FirstSeen;
	private String AuthMode;
	private String SSID;
	private String MAC;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAccuracyMeters() {
		return AccuracyMeters;
	}

	public void setAccuracyMeters(int accuracyMeters) {
		AccuracyMeters = accuracyMeters;
	}

	public double getAltitudeMeters() {
		return AltitudeMeters;
	}

	public void setAltitudeMeters(double altitudeMeters) {
		AltitudeMeters = altitudeMeters;
	}

	public double getCurrentLongitude() {
		return CurrentLongitude;
	}

	public void setCurrentLongitude(double currentLongitude) {
		CurrentLongitude = currentLongitude;
	}

	public double getCurrentLatitude() {
		return CurrentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
		CurrentLatitude = currentLatitude;
	}

	public int getRSSI() {
		return RSSI;
	}

	public void setRSSI(int rSSI) {
		RSSI = rSSI;
	}

	public int getChannel() {
		return Channel;
	}

	public void setChannel(int channel) {
		Channel = channel;
	}

	public String getFirstSeen() {
		return FirstSeen;
	}

	public void setFirstSeen(String firstSeen) {
		FirstSeen = firstSeen;
	}

	public String getAuthMode() {
		return AuthMode;
	}

	public void setAuthMode(String authMode) {
		AuthMode = authMode;
	}

	public String getSSID() {
		return SSID;
	}

	public void setSSID(String sSID) {
		SSID = sSID;
	}

	public String getMAC() {
		return MAC;
	}

	public void setMAC(String mAC) {
		MAC = mAC;
	}

	public CsvLine() {

	}

	public CsvLine(String type, int AccuracyMeters, double AltitudeMeters, double CurrentLongitude,
			double CurrentLatitude, int RSSI, int Channel, String FirstSeen, String AuthMode, String SSID, String MAC) {
		this.type = type;
		this.AccuracyMeters = AccuracyMeters;
		this.AltitudeMeters = AltitudeMeters;
		this.CurrentLongitude = CurrentLongitude;
		this.CurrentLatitude = CurrentLatitude;
		this.RSSI = RSSI;
		this.Channel = Channel;
		this.FirstSeen = FirstSeen;
		this.AuthMode = AuthMode;
		this.SSID = SSID;
		this.MAC = MAC;
	}

	@Override
	public String toString() {
		return "CsvLine [type=" + type + ", AccuracyMeters=" + AccuracyMeters + ", AltitudeMeters=" + AltitudeMeters
				+ ", CurrentLongitude=" + CurrentLongitude + ", CurrentLatitude=" + CurrentLatitude + ", RSSI=" + RSSI
				+ ", Channel=" + Channel + ", FirstSeen=" + FirstSeen + ", AuthMode=" + AuthMode + ", SSID=" + SSID
				+ ", MAC=" + MAC + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}
