package drr.regulation.csa.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.validation.CSANonReportableTypeFormatValidator;
import drr.regulation.csa.rewrite.trade.validation.CSANonReportableValidator;
import drr.regulation.csa.rewrite.trade.validation.exists.CSANonReportableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CSANonReportable.class)
public class CSANonReportableMeta implements RosettaMetaData<CSANonReportable> {

	@Override
	public List<Validator<? super CSANonReportable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CSANonReportable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSANonReportable> validator(ValidatorFactory factory) {
		return factory.<CSANonReportable>create(CSANonReportableValidator.class);
	}

	@Override
	public Validator<? super CSANonReportable> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSANonReportable>create(CSANonReportableTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSANonReportable> validator() {
		return new CSANonReportableValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSANonReportable> typeFormatValidator() {
		return new CSANonReportableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSANonReportable, Set<String>> onlyExistsValidator() {
		return new CSANonReportableOnlyExistsValidator();
	}
}
