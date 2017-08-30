<template lang="pug">
	.userinfo.form-inline
		li.nav-item.dropdown
			a#navbarDropdownMenuLink.nav-link.dropdown-toggle(href='http://example.com', data-toggle='dropdown', aria-haspopup='true', aria-expanded='false')
				| {{$root.user.userName}} {{$root.user.userSurname}} {{$root.user.userPatronymic}}
			.dropdown-menu(aria-labelledby='navbarDropdownMenuLink')
				div.dropinfo
					p
						b Информация о пользователе
					p
						b Email: 
						| {{$root.user.email}}
					p
						b Пол: 
						| {{$root.user.gender.nameOfGender}}
					p
						b Группа: 
						|{{$root.user.studentGroup.numberOfGroup}}, {{$root.user.studentGroup.chair.faculty.university.nameUniversity}}, {{$root.user.studentGroup.chair.faculty.nameFaculty}}, {{$root.user.studentGroup.chair.nameChair}}


		li.nav-item
			a.nav-link(href='#') Выйти
</template>

<style>
	.userinfo a{
		color: rgba(255,255,255,.5);
	}
	.dropdown-menu a{
		color: #444;
	}
	.userinfo a:hover{
		color: rgba(255,255,255,.75);
	}
	.dropdown-menu a:hover{
		color: #000;
	}
	.dropinfo{
		padding: 2px 15px;
	}
	.dropdown-menu{
		width: 260px;
		margin: 10px 0px;
	}
</style>