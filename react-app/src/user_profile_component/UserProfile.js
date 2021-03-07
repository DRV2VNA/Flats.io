import React, { Component } from 'react';
import './nullStyle.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import './UserProfile.css'


class UserProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            // code: props.code ? props.code : '999',
            // description: props.description ? props.description : 'Unknown error'
        }
    }

    render() {
        // const {code, description} = this.state;
        return (
            <div>
                <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"/>
            <div className="container bootstrap snippets bootdeys">
                <div className="row" id="user-profile">
                    <div className="col-lg-3 col-md-4 col-sm-4">
                        <div className="main-box clearfix">
                            <h2>Павел Павлов </h2>
                            <div className="profile-status">
                                <i className="fa fa-check-circle"></i> Онлайн
                            </div>
                            <img src="https://2.bp.blogspot.com/-iaHl5TDyqBg/W_22yrrHtxI/AAAAAAAAJSc/71tQ9aJijrUaOVpzemjWqefCbh5IQbPSgCLcBGAs/s1600/%25D0%259B%25D1%2583%25D1%2587%25D1%2588%25D0%25B8%25D0%25B9%2B%25D1%2587%25D0%25B0%25D1%2581%25D1%2582%25D0%25BD%25D1%258B%25D0%25B9%2B%25D0%25B8%25D0%25BD%25D0%25B2%25D0%25B5%25D1%2581%25D1%2582%25D0%25BE%25D1%2580.png"
                                alt="" className="profile-img img-responsive center-block"/>
                            <div className="profile-label">
                                <span className="label label-success">Инвестор</span>
                            </div>

                            <div className="profile-stars">
                                <i className="fa fa-star"></i>
                                <i className="fa fa-star"></i>
                                <i className="fa fa-star"></i>
                                <i className="fa fa-star"></i>
                                <i className="fa fa-star"></i>
                                <br/><span>Professional Investor</span>
                            </div>
                            <div className="profile-stars">
                                {/*<span className="label label-warning">hr</span>*/}
                                {/*<span className="label label-primary">digital</span>*/}
                                {/*<span className="label label-danger">pr</span>*/}

                            </div>
                            <div className="profile-since">
                                На сайте с: Фев 2021
                            </div>

                            <div className="profile-details">
                                <ul className="fa-ul">
                                    <li><i className="fa-li fa fa-comment"></i>Общение с инициаторами: <span>1700</span>
                                    </li>
                                    <li><i className="fa-li fa fa-tasks"></i>Проинвестированные инициативы: <span>1100</span></li>
                                </ul>
                            </div>

                        </div>
                    </div>

                    <div className="col-lg-9 col-md-8 col-sm-8">
                        <div className="main-box clearfix">
                            <div className="profile-header">
                                <h3><span>Информация о пользователе</span></h3>

                            </div>

                            <div className="row profile-user-info">
                                <div className="col-sm-8">
                                    <div className="profile-user-details clearfix">
                                        <div className="profile-user-details-label">
                                            Компания
                                        </div>
                                        <div className="profile-user-details-value">
                                            ИНВЕСТ
                                        </div>
                                    </div>

                                    <div className="profile-user-details clearfix">
                                        <div className="profile-user-details-label">
                                            Номер
                                        </div>
                                        <div className="profile-user-details-value">
                                            +7-XXX-XXX-XX-XX
                                        </div>
                                    </div>
                                    <div className="profile-user-details clearfix">
                                        <div className="profile-user-details-label">
                                            Email
                                        </div>
                                        <div className="profile-user-details-value">
                                            pavel@google.com
                                        </div>
                                    </div>

                                </div>
                                <div className="col-sm-4 profile-social">
                                    <ul className="fa-ul">
                                        <li><i className="fa-li fa fa-twitter-square"></i><a href="#">@pavelinvest</a></li>
                                        <li><i className="fa-li fa fa-skype"></i><a href="#">money_more</a></li>
                                        <li><i className="fa-li fa fa-instagram"></i><a href="#">business_investor</a></li>
                                    </ul>
                                </div>
                            </div>

                            <div className="tabs-wrapper profile-tabs">
                                <ul className="nav nav-tabs">
                                    <li className="active"><a href="#tab-activity" data-toggle="tab">Активность</a></li>
                                    <li><a href="#tab-friends" data-toggle="tab">Инвестиции</a></li>
                                </ul>

                                <div className="tab-content">
                                    <div className="tab-pane fade in active" id="tab-activity">

                                        <div className="table-responsive">
                                            <table className="table">
                                                <tbody>
                                                    <tr>
                                                        <td className="text-center">
                                                            <i className="fa fa-search"></i>
                                                        </td>
                                                        <td>
                                                            Павел Павлов начал поиск новых <a href="#"> инициатив</a>.

                                                    </td>
                                                        <td>
                                                            2021/02/07 13:22
                                                    </td>
                                                    </tr>
                                                    <td className="text-center">
                                                        <i className="fa fa-users"></i>
                                                    </td>
                                                    <td>
                                                        Павел Павлов просмотрел рейтинг инициаторов по обучению.

                                                </td>
                                                    <td>
                                                        2021/02/07 13:22
                                                </td>


                                                    <tr>
                                                        <td className="text-center">
                                                            <i className="fa fa-check"></i>
                                                        </td>
                                                        <td>
                                                            Павел Павлов успешно вложил инвестиции в <a
                                                                href="#">"Инициатива1"</a>.
                                                    </td>
                                                        <td>
                                                            2021/02/07 13:22
                                                    </td>
                                                    </tr>
                                                    <tr>
                                                        <td className="text-center">
                                                            <i className="fa fa-check"></i>
                                                        </td>
                                                        <td>
                                                            Павел Павлов успешно вложил инвестиции в <a
                                                                href="#">"Инициатива7"</a>.
                                                    </td>
                                                        <td>
                                                            2021/02/07 13:22
                                                    </td>
                                                    </tr>


                                                    <tr>
                                                        <td className="text-center">
                                                            <i className="fa fa-heart"></i>
                                                        </td>
                                                        <td>
                                                            Павлу Павлову были присвоены статусы в связи с выбором областей
                                                            инвестирования
                                                        <span className="label label-warning">hr</span>
                                                            <span className="label label-danger">pr</span>
                                                            <span className="label label-primary">digital</span>
                                                        </td>
                                                        <td>
                                                            2021/02/07 13:22
                                                    </td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>

                                    </div>

                                    <div className="tab-pane fade" id="tab-friends">
                                        <ul className="widget-users row">
                                            <h5 className="d-flex align-items-center mb-3"><i
                                                className="material-icons text-info mr-2"></i>Инициаторы, на которых подписан
                                            инвестор</h5>
                                            <li className="col-md-6">
                                                <div className="img">
                                                    <img src="https://pbs.twimg.com/profile_images/1296338780325056515/esn8pER-_400x400.jpg"
                                                        className="img-responsive" alt="" />
                                                </div>
                                                <div className="details">
                                                    <div className="name">
                                                        <a href="#">Инициатор1 </a>
                                                    </div>
                                                    <div className="time">
                                                        <i className="fa fa-clock-o"></i> Был онлайн: 3 часа назад
                                                </div>
                                                    <div className="type">
                                                        <span className="label label-primary">digital</span>
                                                    </div>
                                                </div>
                                            </li>
                                            <li className="col-md-6">
                                                <div className="img">
                                                    <img src="https://pbs.twimg.com/profile_images/1296338780325056515/esn8pER-_400x400.jpg"
                                                        className="img-responsive" alt="" />
                                                </div>
                                                <div className="details">
                                                    <div className="name">
                                                        <a href="#">Инициатор2</a>
                                                    </div>
                                                    <div className="time online">
                                                        <i className="fa fa-check-circle"></i> Онлайн
                                                </div>
                                                    <div className="type">
                                                        <span className="label label-primary">digital</span>
                                                    </div>
                                                </div>
                                            </li>
                                            <li className="col-md-6">
                                                <div className="img">
                                                    <img src="https://pbs.twimg.com/profile_images/1296338780325056515/esn8pER-_400x400.jpg"
                                                        className="img-responsive" alt="" />
                                                </div>
                                                <div className="details">
                                                    <div className="name">
                                                        <a href="#">Инициатор3</a>
                                                    </div>
                                                    <div className="time online">
                                                        <i className="fa fa-check-circle"></i> Онлайн
                                                </div>
                                                    <div className="type">
                                                        <span className="label label-primary">digital</span>
                                                    </div>
                                                </div>
                                            </li>
                                            <li className="col-md-6">
                                                <div className="img">
                                                    <img src="https://pbs.twimg.com/profile_images/1296338780325056515/esn8pER-_400x400.jpg"
                                                        className="img-responsive" alt="" />
                                                </div>
                                                <div className="details">
                                                    <div className="name">
                                                        <a href="#">Инициатор4</a>
                                                    </div>
                                                    <div className="time">
                                                        <i className="fa fa-clock-o"></i> Был онлайн: Среда
                                                </div>
                                                    <div className="type">
                                                        <span className="label label-warning">hr</span>
                                                    </div>
                                                </div>
                                            </li>
                                            <li className="col-md-6">
                                                <div className="img">
                                                    <img src="https://pbs.twimg.com/profile_images/1296338780325056515/esn8pER-_400x400.jpg"
                                                        className="img-responsive" alt="" />
                                                </div>
                                                <div className="details">
                                                    <div className="name">
                                                        <a href="#">Инициатор5</a>
                                                    </div>
                                                    <div className="time">
                                                        <i className="fa fa-clock-o"></i> Был онлайн: 3 недели назад
                                                </div>
                                                    <div className="type">
                                                        <span className="label label-warning">hr</span>
                                                    </div>
                                                </div>
                                            </li>
                                            <li className="col-md-6">
                                                <div className="img">
                                                    <img src="https://pbs.twimg.com/profile_images/1296338780325056515/esn8pER-_400x400.jpg"
                                                        className="img-responsive" alt="" />
                                                </div>
                                                <div className="details">
                                                    <div className="name">
                                                        <a href="#">Инициатор6</a>
                                                    </div>
                                                    <div className="time">
                                                        <i className="fa fa-clock-o"></i> Был онлайн: 1 месяц назад
                                                </div>
                                                    <div className="type">
                                                        <span className="label label-warning">hr</span>
                                                    </div>
                                                </div>
                                            </li>
                                            <li className="col-md-6">
                                                <div className="img">
                                                    <img src="https://pbs.twimg.com/profile_images/1296338780325056515/esn8pER-_400x400.jpg"
                                                        className="img-responsive" alt="" />
                                                </div>
                                                <div className="details">
                                                    <div className="name">
                                                        <a href="#">Инициатор7</a>
                                                    </div>
                                                    <div className="time online">
                                                        <i className="fa fa-check-circle"></i> Онлайн
                                                </div>
                                                    <div className="type">
                                                        <span className="label label-danger">pr</span>
                                                    </div>
                                                </div>
                                            </li>
                                            <li className="col-md-6">
                                                <div className="img">
                                                    <img src="https://pbs.twimg.com/profile_images/1296338780325056515/esn8pER-_400x400.jpg"
                                                        className="img-responsive" alt="" />
                                                </div>
                                                <div className="details">
                                                    <div className="name">
                                                        <a href="#">Инициатор8</a>
                                                    </div>
                                                    <div className="time online">
                                                        <i className="fa fa-check-circle"></i> Онлайн
                                                </div>
                                                    <div className="type">
                                                        <span className="label label-danger">pr</span>
                                                    </div>
                                                </div>
                                            </li>
                                            <div className="row gutters-sm">
                                                <div className="col-sm-6 mb-3">
                                                    <div className="card h-100">
                                                        <div className="card-body">
                                                            {/*<h5 className="d-flex align-items-center mb-3"><i*/}
                                                            {/*    className="material-icons text-info mr-2"></i>Процесс*/}
                                                            {/*    инвестирования инициатив</h5>*/}
                                                            {/*<small>Инициатива1</small>*/}
                                                            {/*<div className="progress mb-3" /!*style="height: 7px"*!/>*/}
                                                            {/*    <div className="progress-bar bg-warning" role="progressbar"*/}
                                                            {/*         /!*style="width: 95%" aria-valuenow="95" aria-valuemin="0"*/}
                                                            {/*         aria-valuemax="100"*!/></div>*/}
                                                            {/*</div>*/}
                                                            {/*<small>Инициатива2</small>*/}
                                                            {/*<div className="progress mb-3" /!*style="height: 7px"*!/>*/}
                                                            {/*    <div className="progress-bar bg-primary" role="progressbar"*/}
                                                            {/*         /!*style="width: 95%" aria-valuenow="95" aria-valuemin="0"*/}
                                                            {/*         aria-valuemax="100"*!/></div>*/}
                                                            {/*</div>*/}
                                                            {/*<small>Инициатива3</small>*/}
                                                            {/*<div className="progress mb-3" /!*style="height: 7px"*!/>*/}
                                                            {/*    <div className="progress-bar bg-primary" role="progressbar"*/}
                                                            {/*         /!*style="width: 95%" aria-valuenow="95" aria-valuemin="0"*/}
                                                            {/*         aria-valuemax="100"*!/></div>*/}
                                                            {/*</div>*/}
                                                            {/*<small>Инициатива4</small>*/}
                                                            {/*<div className="progress mb-3" /!*style="height: 7px"*!/>*/}
                                                            {/*    <div className="progress-bar bg-primary" role="progressbar"*/}
                                                            {/*         /!*style="width: 95%" aria-valuenow="95" aria-valuemin="0"*/}
                                                            {/*         aria-valuemax="100"*!/></div>*/}
                                                            {/*</div>*/}
                                                            {/*<small>Инициатива5</small>*/}
                                                            {/*<div className="progress mb-3" /!*style="height: 7px"*!/>*/}
                                                            {/*    <div className="progress-bar bg-primary" role="progressbar"*/}
                                                            {/*         /!*style="width: 95%" aria-valuenow="95" aria-valuemin="0"*/}
                                                            {/*         aria-valuemax="100"*!/></div>*/}
                                                            {/*</div>*/}
                                                            {/*<small>Инициатива6</small>*/}
                                                            {/*<div className="progress mb-3" style="height: 7px">*/}
                                                            {/*    <div className="progress-bar bg-primary" role="progressbar"*/}
                                                            {/*         /!*style="width: 95%" aria-valuenow="95" aria-valuemin="0"*/}
                                                            {/*         aria-valuemax="100"*!/></div>*/}
                                                            {/*</div>*/}
                                                            {/*<small>Инициатива7</small>*/}
                                                            {/*<div className="progress mb-3" /!*style="height: 7px"*!/>*/}
                                                            {/*    <div className="progress-bar bg-primary" role="progressbar"*/}
                                                            {/*        /!*style="width: 95%" aria-valuenow="95" aria-valuemin="0"*/}
                                                            {/*         aria-valuemax="100"*!/></div>*/}
                                                            {/*</div>*/}
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </ul>
                                        <br />
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <script src="http://code.jquery.com/jquery-1.10.2.min.js"/>
            <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
            </div>
        );
    }
}

export default UserProfile;