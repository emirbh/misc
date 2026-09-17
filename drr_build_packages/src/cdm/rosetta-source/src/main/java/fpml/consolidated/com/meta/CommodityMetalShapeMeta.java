package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityMetalShape;
import fpml.consolidated.com.validation.CommodityMetalShapeTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityMetalShapeValidator;
import fpml.consolidated.com.validation.exists.CommodityMetalShapeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityMetalShape.class)
public class CommodityMetalShapeMeta implements RosettaMetaData<CommodityMetalShape> {

	@Override
	public List<Validator<? super CommodityMetalShape>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalShape, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityMetalShape> validator(ValidatorFactory factory) {
		return factory.<CommodityMetalShape>create(CommodityMetalShapeValidator.class);
	}

	@Override
	public Validator<? super CommodityMetalShape> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityMetalShape>create(CommodityMetalShapeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMetalShape> validator() {
		return new CommodityMetalShapeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMetalShape> typeFormatValidator() {
		return new CommodityMetalShapeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalShape, Set<String>> onlyExistsValidator() {
		return new CommodityMetalShapeOnlyExistsValidator();
	}
}
