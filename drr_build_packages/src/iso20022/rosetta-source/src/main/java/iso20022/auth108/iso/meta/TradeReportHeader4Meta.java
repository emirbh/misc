package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.TradeReportHeader4;
import iso20022.auth108.iso.validation.TradeReportHeader4TypeFormatValidator;
import iso20022.auth108.iso.validation.TradeReportHeader4Validator;
import iso20022.auth108.iso.validation.exists.TradeReportHeader4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeReportHeader4.class)
public class TradeReportHeader4Meta implements RosettaMetaData<TradeReportHeader4> {

	@Override
	public List<Validator<? super TradeReportHeader4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeReportHeader4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeReportHeader4> validator(ValidatorFactory factory) {
		return factory.<TradeReportHeader4>create(TradeReportHeader4Validator.class);
	}

	@Override
	public Validator<? super TradeReportHeader4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeReportHeader4>create(TradeReportHeader4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeReportHeader4> validator() {
		return new TradeReportHeader4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeReportHeader4> typeFormatValidator() {
		return new TradeReportHeader4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeReportHeader4, Set<String>> onlyExistsValidator() {
		return new TradeReportHeader4OnlyExistsValidator();
	}
}
