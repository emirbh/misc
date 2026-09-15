package drr.base.trade.basket;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import drr.base.trade.basket.meta.BasketConstituentsReportMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="BasketConstituentsReport", builder=BasketConstituentsReport.BasketConstituentsReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="BasketConstituentsReport", model="drr", builder=BasketConstituentsReport.BasketConstituentsReportBuilderImpl.class, version="7.7.0")
public interface BasketConstituentsReport extends RosettaModelObject {

	BasketConstituentsReportMeta metaData = new BasketConstituentsReportMeta();

	/*********************** Getter Methods  ***********************/
	String getIdentifier();
	AssetIdTypeEnum getSource();
	BigDecimal getNumberOfUnits();
	String getUnitOfMeasure();

	/*********************** Build Methods  ***********************/
	BasketConstituentsReport build();
	
	BasketConstituentsReport.BasketConstituentsReportBuilder toBuilder();
	
	static BasketConstituentsReport.BasketConstituentsReportBuilder builder() {
		return new BasketConstituentsReport.BasketConstituentsReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketConstituentsReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketConstituentsReport> getType() {
		return BasketConstituentsReport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("identifier"), String.class, getIdentifier(), this);
		processor.processBasic(path.newSubPath("source"), AssetIdTypeEnum.class, getSource(), this);
		processor.processBasic(path.newSubPath("numberOfUnits"), BigDecimal.class, getNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("unitOfMeasure"), String.class, getUnitOfMeasure(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketConstituentsReportBuilder extends BasketConstituentsReport, RosettaModelObjectBuilder {
		BasketConstituentsReport.BasketConstituentsReportBuilder setIdentifier(String identifier);
		BasketConstituentsReport.BasketConstituentsReportBuilder setSource(AssetIdTypeEnum source);
		BasketConstituentsReport.BasketConstituentsReportBuilder setNumberOfUnits(BigDecimal numberOfUnits);
		BasketConstituentsReport.BasketConstituentsReportBuilder setUnitOfMeasure(String unitOfMeasure);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("identifier"), String.class, getIdentifier(), this);
			processor.processBasic(path.newSubPath("source"), AssetIdTypeEnum.class, getSource(), this);
			processor.processBasic(path.newSubPath("numberOfUnits"), BigDecimal.class, getNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("unitOfMeasure"), String.class, getUnitOfMeasure(), this);
		}
		

		BasketConstituentsReport.BasketConstituentsReportBuilder prune();
	}

	/*********************** Immutable Implementation of BasketConstituentsReport  ***********************/
	class BasketConstituentsReportImpl implements BasketConstituentsReport {
		private final String identifier;
		private final AssetIdTypeEnum source;
		private final BigDecimal numberOfUnits;
		private final String unitOfMeasure;
		
		protected BasketConstituentsReportImpl(BasketConstituentsReport.BasketConstituentsReportBuilder builder) {
			this.identifier = builder.getIdentifier();
			this.source = builder.getSource();
			this.numberOfUnits = builder.getNumberOfUnits();
			this.unitOfMeasure = builder.getUnitOfMeasure();
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public String getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("source")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("source")
		public AssetIdTypeEnum getSource() {
			return source;
		}
		
		@Override
		@RosettaAttribute("numberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfUnits")
		public BigDecimal getNumberOfUnits() {
			return numberOfUnits;
		}
		
		@Override
		@RosettaAttribute("unitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitOfMeasure")
		public String getUnitOfMeasure() {
			return unitOfMeasure;
		}
		
		@Override
		public BasketConstituentsReport build() {
			return this;
		}
		
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder toBuilder() {
			BasketConstituentsReport.BasketConstituentsReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketConstituentsReport.BasketConstituentsReportBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getSource()).ifPresent(builder::setSource);
			ofNullable(getNumberOfUnits()).ifPresent(builder::setNumberOfUnits);
			ofNullable(getUnitOfMeasure()).ifPresent(builder::setUnitOfMeasure);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituentsReport _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(source, _that.getSource())) return false;
			if (!Objects.equals(numberOfUnits, _that.getNumberOfUnits())) return false;
			if (!Objects.equals(unitOfMeasure, _that.getUnitOfMeasure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (numberOfUnits != null ? numberOfUnits.hashCode() : 0);
			_result = 31 * _result + (unitOfMeasure != null ? unitOfMeasure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituentsReport {" +
				"identifier=" + this.identifier + ", " +
				"source=" + this.source + ", " +
				"numberOfUnits=" + this.numberOfUnits + ", " +
				"unitOfMeasure=" + this.unitOfMeasure +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketConstituentsReport  ***********************/
	class BasketConstituentsReportBuilderImpl implements BasketConstituentsReport.BasketConstituentsReportBuilder {
	
		protected String identifier;
		protected AssetIdTypeEnum source;
		protected BigDecimal numberOfUnits;
		protected String unitOfMeasure;
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public String getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("source")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("source")
		public AssetIdTypeEnum getSource() {
			return source;
		}
		
		@Override
		@RosettaAttribute("numberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfUnits")
		public BigDecimal getNumberOfUnits() {
			return numberOfUnits;
		}
		
		@Override
		@RosettaAttribute("unitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitOfMeasure")
		public String getUnitOfMeasure() {
			return unitOfMeasure;
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("identifier")
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder setIdentifier(String _identifier) {
			this.identifier = _identifier == null ? null : _identifier;
			return this;
		}
		
		@RosettaAttribute("source")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("source")
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder setSource(AssetIdTypeEnum _source) {
			this.source = _source == null ? null : _source;
			return this;
		}
		
		@RosettaAttribute("numberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfUnits")
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder setNumberOfUnits(BigDecimal _numberOfUnits) {
			this.numberOfUnits = _numberOfUnits == null ? null : _numberOfUnits;
			return this;
		}
		
		@RosettaAttribute("unitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unitOfMeasure")
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder setUnitOfMeasure(String _unitOfMeasure) {
			this.unitOfMeasure = _unitOfMeasure == null ? null : _unitOfMeasure;
			return this;
		}
		
		@Override
		public BasketConstituentsReport build() {
			return new BasketConstituentsReport.BasketConstituentsReportImpl(this);
		}
		
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null) return true;
			if (getSource()!=null) return true;
			if (getNumberOfUnits()!=null) return true;
			if (getUnitOfMeasure()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketConstituentsReport.BasketConstituentsReportBuilder o = (BasketConstituentsReport.BasketConstituentsReportBuilder) other;
			
			
			merger.mergeBasic(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeBasic(getSource(), o.getSource(), this::setSource);
			merger.mergeBasic(getNumberOfUnits(), o.getNumberOfUnits(), this::setNumberOfUnits);
			merger.mergeBasic(getUnitOfMeasure(), o.getUnitOfMeasure(), this::setUnitOfMeasure);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituentsReport _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(source, _that.getSource())) return false;
			if (!Objects.equals(numberOfUnits, _that.getNumberOfUnits())) return false;
			if (!Objects.equals(unitOfMeasure, _that.getUnitOfMeasure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (numberOfUnits != null ? numberOfUnits.hashCode() : 0);
			_result = 31 * _result + (unitOfMeasure != null ? unitOfMeasure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituentsReportBuilder {" +
				"identifier=" + this.identifier + ", " +
				"source=" + this.source + ", " +
				"numberOfUnits=" + this.numberOfUnits + ", " +
				"unitOfMeasure=" + this.unitOfMeasure +
			'}';
		}
	}
}
