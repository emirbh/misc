package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.PaperCommodityOther1__1;
import iso20022.auth030.fca.validation.PaperCommodityOther1__1TypeFormatValidator;
import iso20022.auth030.fca.validation.PaperCommodityOther1__1Validator;
import iso20022.auth030.fca.validation.exists.PaperCommodityOther1__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaperCommodityOther1__1.class)
public class PaperCommodityOther1__1Meta implements RosettaMetaData<PaperCommodityOther1__1> {

	@Override
	public List<Validator<? super PaperCommodityOther1__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaperCommodityOther1__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaperCommodityOther1__1> validator(ValidatorFactory factory) {
		return factory.<PaperCommodityOther1__1>create(PaperCommodityOther1__1Validator.class);
	}

	@Override
	public Validator<? super PaperCommodityOther1__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaperCommodityOther1__1>create(PaperCommodityOther1__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityOther1__1> validator() {
		return new PaperCommodityOther1__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityOther1__1> typeFormatValidator() {
		return new PaperCommodityOther1__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaperCommodityOther1__1, Set<String>> onlyExistsValidator() {
		return new PaperCommodityOther1__1OnlyExistsValidator();
	}
}
