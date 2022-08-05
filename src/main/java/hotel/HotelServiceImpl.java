package hotel;


import java.util.ArrayList;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hotelservice")
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDAO dao;

	
	public int postHotel(HotelPostDTO dto) {
		return dao.postHotel(dto);
	}
	public int postHotelName(HotelPostDTO dto) throws Exception {
		return dao.postHotelName(dto);
	}
	public int postHotelRoom(HotelRoomDTO dto){
		return dao.postHotelRoom(dto);
	}
	public int postHotelPicture(HotelPictureDTO dto){
		return dao.postHotelPicture(dto);
	}
	public int postReservation(HotelReservationDTO dto) {
		return dao.postReservation(dto);
	}
	public int addceo(HotelceoDTO dto) {
		return dao.addceo(dto);
	}
	public int updateHotel(HotelPostDTO dto) {
		return dao.updateHotel(dto);
	}
	public int updateHotelName(HotelPostDTO dto){
		return dao.updateHotelName(dto);
	}
	public int updateHotelRoom(HotelRoomDTO dto){
		return dao.updateHotelRoom(dto);
	}
	public int updateHotelPicture(HotelPictureDTO dto){
		return dao.updateHotelPicture(dto);
	}
	public int updateHotelPicture(HotelPostDTO dto){
		return dao.updateHotelPicture(dto);
	}
	public int updateReservationCancle(String reservation_id) {
		return dao.updateReservationCancle(reservation_id);
	}
	public int updateReservationConfirm(String reservation_id) {
		return dao.updateReservationConfirm(reservation_id);
	}
	public int selectHotelcount(HotelPostDTO dto){
		return dao.selectHotelcount(dto);
	}
	public int isBusinessId(String business_id) {
		return dao.isBusinessId(business_id);
		
	}
	public ArrayList<HotelPostDTO> selecthotelsearch(String[] str,int page) {
		return dao.selecthotelsearch(str,page);
	}
	public ArrayList<HotelReservationDTO> selectReservationsbybids(String business_id){
		return dao.selectReservationsbybids(business_id);
	}
	public ArrayList<HotelReservationDTO> selectReservationsbyuids(String user_id){
		return dao.selectReservationsbyuids(user_id);
	}
	public ArrayList<HotelceoDTO> selectHotelceobyhids(String business_id){
		return dao.selectHotelceobyhids(business_id);
	}
	public ArrayList<HotelPostDTO> selectHotelbyhids(String hotel_id){
		return dao.selectHotelbyhids(hotel_id);
	}
	public ArrayList<HotelPictureDTO> selectHotelPicturebyhids(String hotel_id) {
		return dao.selectHotelPicturebyhids(hotel_id);
	}
	public ArrayList<HotelPostDTO> selectHotelpagelist(int page) {
		return dao.selectHotelpagelist(page);
	}; 
	public ArrayList<HotelPostDTO> selectHotelManageList(HotelPostDTO dto){
		return dao.selectHotelManageList(dto);
	}
	public ArrayList<HotelPostDTO> selectHotelid(HotelPostDTO dto){
		return dao.selectHotelid(dto);
	}
	public ArrayList<HotelPostDTO> selectHotelhid(HotelPostDTO dto){
		return dao.selectHotelhid(dto);
	}
	public ArrayList<HotelRoomDTO> selectHotelRoombyhids(String hotel_id){
		return dao.selectHotelRoombyhids(hotel_id);
	}
	public ArrayList<HotelRoomDTO> selectHotelRoombyhid(HotelPostDTO dto){
		return dao.selectHotelRoombyhid(dto);
	}
	public ArrayList<HotelPictureDTO> selectHotelPicturebyhid(HotelPostDTO dto){
		return dao.selectHotelPicturebyhid(dto);
	}
	public int deleteHotel(String hotel_id) {
		return dao.deleteHotel(hotel_id);
	}
	public int deleteHotelROOMbyString(String hotel_id) {
		return dao.deleteHotelROOMbyString(hotel_id);
	}
	public int deleteHotelPicturebyString(String hotel_id){
		return dao.deleteHotelPicturebyString(hotel_id);
	}
	public int deleteHotelROOM(HotelPostDTO dto){
		return dao.deleteHotelROOM(dto);
	}; 
	public int deleteHotelPicture(HotelPostDTO dto){
		return dao.deleteHotelPicture(dto);
	}; 
}
