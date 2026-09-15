package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityHub;
import fpml.consolidated.com.validation.CommodityHubTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityHubValidator;
import fpml.consolidated.com.validation.exists.CommodityHubOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityHub.class)
public class CommodityHubMeta implements RosettaMetaData<CommodityHub> {

	@Override
	public List<Validator<? super CommodityHub>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityHub, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityHub> validator(ValidatorFactory factory) {
		return factory.<CommodityHub>create(CommodityHubValidator.class);
	}

	@Override
	public Validator<? super CommodityHub> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityHub>create(CommodityHubTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityHub> validator() {
		return new CommodityHubValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityHub> typeFormatValidator() {
		return new CommodityHubTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityHub, Set<String>> onlyExistsValidator() {
		return new CommodityHubOnlyExistsValidator();
	}
}
