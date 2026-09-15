package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.PaperCommodityOther1;
import iso20022.auth030.hkma.dtcc.validation.PaperCommodityOther1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.PaperCommodityOther1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.PaperCommodityOther1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaperCommodityOther1.class)
public class PaperCommodityOther1Meta implements RosettaMetaData<PaperCommodityOther1> {

	@Override
	public List<Validator<? super PaperCommodityOther1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaperCommodityOther1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaperCommodityOther1> validator(ValidatorFactory factory) {
		return factory.<PaperCommodityOther1>create(PaperCommodityOther1Validator.class);
	}

	@Override
	public Validator<? super PaperCommodityOther1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaperCommodityOther1>create(PaperCommodityOther1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityOther1> validator() {
		return new PaperCommodityOther1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityOther1> typeFormatValidator() {
		return new PaperCommodityOther1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaperCommodityOther1, Set<String>> onlyExistsValidator() {
		return new PaperCommodityOther1OnlyExistsValidator();
	}
}
