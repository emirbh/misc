package iso20022.auth108.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.tr.TradeData61Choice__1;
import iso20022.auth108.hkma.tr.validation.TradeData61Choice__1TypeFormatValidator;
import iso20022.auth108.hkma.tr.validation.TradeData61Choice__1Validator;
import iso20022.auth108.hkma.tr.validation.exists.TradeData61Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData61Choice__1.class)
public class TradeData61Choice__1Meta implements RosettaMetaData<TradeData61Choice__1> {

	@Override
	public List<Validator<? super TradeData61Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData61Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData61Choice__1> validator(ValidatorFactory factory) {
		return factory.<TradeData61Choice__1>create(TradeData61Choice__1Validator.class);
	}

	@Override
	public Validator<? super TradeData61Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData61Choice__1>create(TradeData61Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData61Choice__1> validator() {
		return new TradeData61Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData61Choice__1> typeFormatValidator() {
		return new TradeData61Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData61Choice__1, Set<String>> onlyExistsValidator() {
		return new TradeData61Choice__1OnlyExistsValidator();
	}
}
