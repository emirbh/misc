package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.PolypropyleneCommodityPlastic2;
import iso20022.auth030.hkma.dtcc.validation.PolypropyleneCommodityPlastic2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.PolypropyleneCommodityPlastic2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.PolypropyleneCommodityPlastic2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PolypropyleneCommodityPlastic2.class)
public class PolypropyleneCommodityPlastic2Meta implements RosettaMetaData<PolypropyleneCommodityPlastic2> {

	@Override
	public List<Validator<? super PolypropyleneCommodityPlastic2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PolypropyleneCommodityPlastic2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PolypropyleneCommodityPlastic2> validator(ValidatorFactory factory) {
		return factory.<PolypropyleneCommodityPlastic2>create(PolypropyleneCommodityPlastic2Validator.class);
	}

	@Override
	public Validator<? super PolypropyleneCommodityPlastic2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PolypropyleneCommodityPlastic2>create(PolypropyleneCommodityPlastic2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PolypropyleneCommodityPlastic2> validator() {
		return new PolypropyleneCommodityPlastic2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PolypropyleneCommodityPlastic2> typeFormatValidator() {
		return new PolypropyleneCommodityPlastic2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PolypropyleneCommodityPlastic2, Set<String>> onlyExistsValidator() {
		return new PolypropyleneCommodityPlastic2OnlyExistsValidator();
	}
}
