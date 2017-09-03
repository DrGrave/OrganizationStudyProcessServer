<template lang="pug">
	.starter-template
		h2
			|Subjects
		table.table.table-striped
			tr
				th Subject
				th № Work
				th Name of work
				th Last date
			tr(v-for="(subject, index) in subjects")
				td {{subject.idOfWork.subject.nameSubject}}
				td {{subject.idOfWork.numberOfWOrk}}
				td {{subject.idOfWork.nameOfWork}}
				td {{subject.deadlineForWork}}
</template>

<script>
	export default{
		data(){
        	return {
        		subjects: this.getSubjects()
        	}
    	},
		methods: {
			getSubjects: function(){
				var myHeaders = new Headers();
				myHeaders.append("Authorization", localStorage.getItem("Auth"));
				myHeaders.append("Content-Type", "application/json");
				var urlSubjects = '/StudentWork/Subject/ToStudentWorks/'+this.$root.user.idUser;
				console.log(urlSubjects);
				var self = this;
				fetch(urlSubjects, {
					method: "GET",
					headers: myHeaders,
				}).then(function(r){
      				console.log(r);
      				return r.json();
    			}).then(function(res){
        			console.log(res);
        			self.subjects = res;
        		}).catch(function(err){
        			alert("Произошла ошибка");
        			console.error(err);
    			});
			}
		}
	}
</script>