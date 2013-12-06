package com.logic.timeControllerImpl;

import java.rmi.RemoteException;
import java.util.Calendar;

public class TimeControllerMethodImpl implements
		com.timeControllerService.TimeController {
	private Calendar systemTime;
	private SystemPeriod period;

	public TimeControllerMethodImpl() {
		period = new SystemPeriod();
		setSystemTime(Calendar.getInstance());
	}

	public void setSystemTime(Calendar time) {
		systemTime = time;
	}

	private Calendar addDay(Calendar c, int i) {
		c.add(Calendar.DATE, i);
		return c;
	}

	@Override
	public boolean isTimeForPublishCourse() {
		// TODO Auto-generated method stub
		if (((systemTime.after(addDay(period.getTermOneStartDay(), -1))) && (systemTime
				.before(addDay(period.getTermOneEndDay(), -6))))
				|| ((systemTime.after(addDay(period.getTermTwoStartDay(), -1))) && (systemTime
						.before(addDay(period.getTermTwoEndDay(), -6))))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isTimeForSelectCourse() {
		// TODO Auto-generated method stub
		if (((systemTime.after(addDay(period.getTermOneEndDay(), -8))) && (systemTime
				.before(period.getWinterStartDay())))
				|| ((systemTime.after(addDay(period.getTermTwoEndDay(), -8))) && (systemTime
						.before(period.getSummerStartDay())))) {
			return true;
			// } else if ((s.getGrade() == 1)
			// && ((systemTime.after(addDay(period.getTermOneStartDay(), -1)))
			// && (systemTime
			// .before(addDay(period.getTermOneStartDay(), 8))))) {
			// return true;
		} else
			return false;
	}

	@Override
	public boolean isTimeForSystemSelect() {
		// TODO Auto-generated method stub
		if (((systemTime.after(period.getTermOneEndDay())) && (systemTime
				.before(period.getTermTwoStartDay())))
				|| ((systemTime.after(period.getTermTwoEndDay())) && (systemTime
						.before(addDay(period.getSummerEndDay(), 1))))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isTimeForQuitCourse() {
		// TODO Auto-generated method stub
		if (((systemTime.after(addDay(period.getTermOneStartDay(), -1))) && (systemTime
				.before(addDay(period.getTermOneStartDay(), 15))))
				|| ((systemTime.after(addDay(period.getTermTwoStartDay(), -1))) && (systemTime
						.before(addDay(period.getTermTwoStartDay(), 15))))) {
			return true;
			// } else if ((s.getGrade() == 1)
			// && ((systemTime.after(addDay(period.getTermOneStartDay(), 6))) &&
			// (systemTime
			// .before(addDay(period.getTermOneStartDay(), 15))))) {
			// return true;
		} else
			return false;
	}

	@Override
	public boolean isTimeForGradeOneSelectCourse() {
		// TODO Auto-generated method stub
		if ((systemTime.after(addDay(period.getTermOneStartDay(), -1)))
				&& (systemTime.before(addDay(period.getTermOneStartDay(), 8)))) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean isTimeForByElection() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
