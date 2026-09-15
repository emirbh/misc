package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.PolypropyleneCommodityOther2;
import iso20022.auth030.hkma.dtcc.validation.PolypropyleneCommodityOther2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.PolypropyleneCommodityOther2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.PolypropyleneCommodityOther2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PolypropyleneCommodityOther2.class)
public class PolypropyleneCommodityOther2Meta implements RosettaMetaData<PolypropyleneCommodityOther2> {

	@Override
	public List<Validator<? super PolypropyleneCommodityOther2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PolypropyleneCommodityOther2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PolypropyleneCommodityOther2> validator(ValidatorFactory factory) {
		return factory.<PolypropyleneCommodityOther2>create(PolypropyleneCommodityOther2Validator.class);
	}

	@Override
	public Validator<? super PolypropyleneCommodityOther2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PolypropyleneCommodityOther2>create(PolypropyleneCommodityOther2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PolypropyleneCommodityOther2> validator() {
		return new PolypropyleneCommodityOther2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PolypropyleneCommodityOther2> typeFormatValidator() {
		return new PolypropyleneCommodityOther2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PolypropyleneCommodityOther2, Set<String>> onlyExistsValidator() {
		return new PolypropyleneCommodityOther2OnlyExistsValidator();
	}
}
