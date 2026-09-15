package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.TradeNonConfirmation1;
import iso20022.auth030.hkma.dtcc.validation.TradeNonConfirmation1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.TradeNonConfirmation1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.TradeNonConfirmation1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeNonConfirmation1.class)
public class TradeNonConfirmation1Meta implements RosettaMetaData<TradeNonConfirmation1> {

	@Override
	public List<Validator<? super TradeNonConfirmation1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeNonConfirmation1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeNonConfirmation1> validator(ValidatorFactory factory) {
		return factory.<TradeNonConfirmation1>create(TradeNonConfirmation1Validator.class);
	}

	@Override
	public Validator<? super TradeNonConfirmation1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeNonConfirmation1>create(TradeNonConfirmation1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeNonConfirmation1> validator() {
		return new TradeNonConfirmation1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeNonConfirmation1> typeFormatValidator() {
		return new TradeNonConfirmation1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNonConfirmation1, Set<String>> onlyExistsValidator() {
		return new TradeNonConfirmation1OnlyExistsValidator();
	}
}
