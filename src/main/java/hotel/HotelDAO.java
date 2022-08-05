package hotel;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("hoteldao")
public interface HotelDAO {
	public int postHotel(HotelPostDTO dto); 
	public int postHotelName(HotelPostDTO dto); 
	public int postHotelRoom(HotelRoomDTO dto); 
	public int postHotelPicture(HotelPictureDTO dto); 
	public int postReservation(HotelReservationDTO dto); 
	
	public int addceo(HotelceoDTO dto); 
	public int isBusinessId(String business_id); 
	public int updateHotel(HotelPostDTO dto); 
	public int updateHotelName(HotelPostDTO dto); 
	public int updateHotelRoom(HotelRoomDTO dto); 
	public int updateHotelPicture(HotelPictureDTO dto); 
	public int updateHotelPicture(HotelPostDTO dto);
	public int updateReservationCancle(String reservation_id);
	public int updateReservationConfirm(String reservation_id);
	
	public ArrayList<HotelPostDTO> selecthotelsearch(String[] str,int page); 
	public int selectHotelcount(HotelPostDTO dto); 
	public ArrayList<HotelReservationDTO> selectReservationsbybids(String business_id);
	public ArrayList<HotelReservationDTO> selectReservationsbyuids(String user_id);
	public ArrayList<HotelceoDTO> selectHotelceobyhids(String business_id);
	public ArrayList<HotelPictureDTO> selectHotelPicturebyhids(String hotel_id);
	public ArrayList<HotelPostDTO> selectHotelbyhids(String hotel_id);
	public ArrayList<HotelPostDTO> selectHotelpagelist(int page); 
	public ArrayList<HotelPostDTO> selectHotelManageList(HotelPostDTO dto); 
	public ArrayList<HotelPostDTO> selectHotelid(HotelPostDTO dto); 
	public ArrayList<HotelPostDTO> selectHotelhid(HotelPostDTO dto); 
	public ArrayList<HotelRoomDTO> selectHotelRoombyhid(HotelPostDTO dto);
	public ArrayList<HotelRoomDTO> selectHotelRoombyhids(String hotel_id);
	public ArrayList<HotelPictureDTO> selectHotelPicturebyhid(HotelPostDTO dto);
	public int deleteHotel(String hotel_id); 
	public int deleteHotelROOMbyString(String hotel_id); 
	public int deleteHotelPicturebyString(String hotel_id);
	public int deleteHotelROOM(HotelPostDTO dto); 
	public int deleteHotelPicture(HotelPostDTO dto);
}
