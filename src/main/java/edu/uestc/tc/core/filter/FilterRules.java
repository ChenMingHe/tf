package edu.uestc.tc.core.filter;

import edu.uestc.tc.beans.VehicleInfo;

//注意：现在暂时思考返回布尔值，确切情况应该是返回一个异常


/**
 * 过滤器规则顶层接口，所有过滤规则都需要实现该接口
 * @author MingHe
 *
 */
public interface FilterRules {
	
	/**
	 * @param info 车辆移动信息数据
	 * 对车辆的位置进行过滤
	 */
	void check(VehicleInfo info) throws Exception;
}
