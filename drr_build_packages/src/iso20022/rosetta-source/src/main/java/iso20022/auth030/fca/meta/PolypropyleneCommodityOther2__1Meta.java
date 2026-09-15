package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.PolypropyleneCommodityOther2__1;
import iso20022.auth030.fca.validation.PolypropyleneCommodityOther2__1TypeFormatValidator;
import iso20022.auth030.fca.validation.PolypropyleneCommodityOther2__1Validator;
import iso20022.auth030.fca.validation.exists.PolypropyleneCommodityOther2__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PolypropyleneCommodityOther2__1.class)
public class PolypropyleneCommodityOther2__1Meta implements RosettaMetaData<PolypropyleneCommodityOther2__1> {

	@Override
	public List<Validator<? super PolypropyleneCommodityOther2__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PolypropyleneCommodityOther2__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PolypropyleneCommodityOther2__1> validator(ValidatorFactory factory) {
		return factory.<PolypropyleneCommodityOther2__1>create(PolypropyleneCommodityOther2__1Validator.class);
	}

	@Override
	public Validator<? super PolypropyleneCommodityOther2__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PolypropyleneCommodityOther2__1>create(PolypropyleneCommodityOther2__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PolypropyleneCommodityOther2__1> validator() {
		return new PolypropyleneCommodityOther2__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PolypropyleneCommodityOther2__1> typeFormatValidator() {
		return new PolypropyleneCommodityOther2__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PolypropyleneCommodityOther2__1, Set<String>> onlyExistsValidator() {
		return new PolypropyleneCommodityOther2__1OnlyExistsValidator();
	}
}
