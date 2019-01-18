
function tiankong(){
	var container = $("#container");
	container.append(`
		<div class="form-group">
	        <div class="col-sm-10">
	          <input type="text" class="form-control" id="text" placeholder="填空题题目">
	        </div>
	        <div class="col-sm-10">
	          <input type="text" class="form-control" id="text" placeholder="回答" disabled>
	        </div>
      	</div>
		`)
}

function danxuan(){
	var container = $("#container");
	container.append(`
		<fieldset class="form-group">
	        <div>
	          <legend class="col-form-label col-sm-10 pt-0">
				<input type="text" class="form-control" id="text" placeholder="单选题题目">
	          </legend>

	          <div class="col-sm-10">
	            <div class="form-check">
	              <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1">
	              <input type="text" class="form-control" id="text" placeholder="选项A">
	            </div>

	            <div class="form-check">
	              <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
	              <input type="text" class="form-control" id="text" placeholder="选项B">
	            </div>

	            <div class="form-check disabled">
	              <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3">
	              <input type="text" class="form-control" id="text" placeholder="选项C">
	            </div>

	            <div class="form-check disabled">
	              <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3">
	              <input type="text" class="form-control" id="text" placeholder="选项D">
	            </div>

	          </div>
	        </div>
        </fieldset>
		`)
}

function duoxuan(){
	var container = $("#container");
	container.append(`
		<div class="form-group">
			<legend class="col-form-label col-sm-10 pt-0">
				<input type="text" class="form-control" id="text" placeholder="多选题题目">
	        </legend>
        <div class="col-sm-10">

          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck1">
            <input type="text" class="form-control" id="text" placeholder="选项A">
          </div>
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck1">
            <input type="text" class="form-control" id="text" placeholder="选项B">
          </div>
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck1">
            <input type="text" class="form-control" id="text" placeholder="选项C">
          </div>
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck1">
            <input type="text" class="form-control" id="text" placeholder="选项D">
          </div>
        </div>
      </div>
      `);
}

function panduan(){
	var container = $("#container");
	container.append(`
		<div class="form-group">
			<legend class="col-form-label col-sm-10 pt-0">
				<input type="text" class="form-control" id="text" placeholder="判断题题目">
	        </legend>
        <div class="col-sm-10">
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck1">
            <input type="text" class="form-control" id="text" placeholder="正确与否/支持与否">
          </div>
        </div>
      </div>
		`)
}

