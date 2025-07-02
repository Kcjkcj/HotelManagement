import React, {useState, Component} from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { ko } from 'date-fns/locale';
import './SelectDate.css';
import moment from 'moment';

export default class SelectDate extends Component {

    constructor(props) {
        super(props);
        this.state = {
            startDate:null,
            endDate:null,
        }
    }
    
    setChangeDate=(dates)=>{
        const [start,end]=dates;
        this.setState({startDate:start,endDate:end})
        
        const sdate = moment(start).format("YYYY/MM/DD");
        const edate = moment(end).format("YYYY/MM/DD");
        sessionStorage.setItem("startDate", sdate);
        sessionStorage.setItem("endDate", edate);
    }   
    
    render() {
        return (
            <div className='selcDateHeader'> 
                <div className='nalja'>체크인 - 체크아웃</div>
               <DatePicker 
                    selectsRange={true}
                    className="datepicker"
                    locale={ko}
                    dateFormat="yyyy/MM/dd"
                    selected={this.state.startDate}
                    startDate={this.state.startDate}
                    endDate={this.state.endDate}
                    minDate={new Date()}
                    onChange={(dates)=>this.setChangeDate(dates)}
                    monthsShown={2}
                    showPopperArrow={false} // 화살표 없애기
                    placeholderText="날짜를 선택해 주세요"
                    shoudCloseOnSelect={true}
                    />
            </div>
        );
    }
}

/*const SelectDate = () => {
    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setEndDate] = useState(new Date());
    const setChangeDate=(dates)=>{
        const [start,end]=dates;
        setState({startDate:start,endDate:end})
    }
        return (
        <div className='Cal'>
            <div>
            <DatePicker
            selectRange={true}
            locale={ko}
            minDate={new Date()}
            dateFormat="yyyy/MM/dd"
            selected={startDate}
            startDate={startDate}
            endDate={endDate}
            onChange={(dates)=>setChangeDate(dates)}
            showPopperArrow={false} //디폴트 스타일로 있는 뾰족한 화살표 없애기
            monthsShown={2} // 달력 2개 보이기
            />
            </div>
        </div>
    );
};
export default SelectDate;
https://jiyumi00.tistory.com/54 <<< 참고*/