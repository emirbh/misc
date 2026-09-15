package drr.base.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.ReportingSide;
import drr.base.trade.validation.ReportingSideTypeFormatValidator;
import drr.base.trade.validation.ReportingSideValidator;
import drr.base.trade.validation.exists.ReportingSideOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportingSide.class)
public class ReportingSideMeta implements RosettaMetaData<ReportingSide> {

	@Override
	public List<Validator<? super ReportingSide>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingSide, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingSide> validator(ValidatorFactory factory) {
		return factory.<ReportingSide>create(ReportingSideValidator.class);
	}

	@Override
	public Validator<? super ReportingSide> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingSide>create(ReportingSideTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingSide> validator() {
		return new ReportingSideValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingSide> typeFormatValidator() {
		return new ReportingSideTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingSide, Set<String>> onlyExistsValidator() {
		return new ReportingSideOnlyExistsValidator();
	}
}
