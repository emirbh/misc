package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CoalAttributePercentageMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The different options for specifying the attributes of a coal quality measure as a percentage of the measured value.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The different options for specifying the attributes of a coal quality measure as a percentage of the measured value.
 *
 */
@RosettaDataType(value="CoalAttributePercentage", builder=CoalAttributePercentage.CoalAttributePercentageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CoalAttributePercentage", model="fpml", builder=CoalAttributePercentage.CoalAttributePercentageBuilderImpl.class, version="2.1.1")
public interface CoalAttributePercentage extends RosettaModelObject {

	CoalAttributePercentageMeta metaData = new CoalAttributePercentageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The actual content of the quality characteristics of the Coal Product Shipment expected by the Buyer. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The actual content of the quality characteristics of the Coal Product Shipment expected by the Buyer. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getStandardContent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The actual limits of the quality characteristics of the Coal Product above or below which the Buyer may reject a Shipment. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The actual limits of the quality characteristics of the Coal Product above or below which the Buyer may reject a Shipment. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getRejectionLimit();

	/*********************** Build Methods  ***********************/
	CoalAttributePercentage build();
	
	CoalAttributePercentage.CoalAttributePercentageBuilder toBuilder();
	
	static CoalAttributePercentage.CoalAttributePercentageBuilder builder() {
		return new CoalAttributePercentage.CoalAttributePercentageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalAttributePercentage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoalAttributePercentage> getType() {
		return CoalAttributePercentage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardContent"), BigDecimal.class, getStandardContent(), this);
		processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalAttributePercentageBuilder extends CoalAttributePercentage, RosettaModelObjectBuilder {
		CoalAttributePercentage.CoalAttributePercentageBuilder setStandardContent(BigDecimal standardContent);
		CoalAttributePercentage.CoalAttributePercentageBuilder setRejectionLimit(BigDecimal rejectionLimit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardContent"), BigDecimal.class, getStandardContent(), this);
			processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
		}
		

		CoalAttributePercentage.CoalAttributePercentageBuilder prune();
	}

	/*********************** Immutable Implementation of CoalAttributePercentage  ***********************/
	class CoalAttributePercentageImpl implements CoalAttributePercentage {
		private final BigDecimal standardContent;
		private final BigDecimal rejectionLimit;
		
		protected CoalAttributePercentageImpl(CoalAttributePercentage.CoalAttributePercentageBuilder builder) {
			this.standardContent = builder.getStandardContent();
			this.rejectionLimit = builder.getRejectionLimit();
		}
		
		@Override
		@RosettaAttribute("standardContent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("standardContent")
		public BigDecimal getStandardContent() {
			return standardContent;
		}
		
		@Override
		@RosettaAttribute("rejectionLimit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rejectionLimit")
		public BigDecimal getRejectionLimit() {
			return rejectionLimit;
		}
		
		@Override
		public CoalAttributePercentage build() {
			return this;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder toBuilder() {
			CoalAttributePercentage.CoalAttributePercentageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalAttributePercentage.CoalAttributePercentageBuilder builder) {
			ofNullable(getStandardContent()).ifPresent(builder::setStandardContent);
			ofNullable(getRejectionLimit()).ifPresent(builder::setRejectionLimit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributePercentage _that = getType().cast(o);
		
			if (!Objects.equals(standardContent, _that.getStandardContent())) return false;
			if (!Objects.equals(rejectionLimit, _that.getRejectionLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardContent != null ? standardContent.hashCode() : 0);
			_result = 31 * _result + (rejectionLimit != null ? rejectionLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributePercentage {" +
				"standardContent=" + this.standardContent + ", " +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalAttributePercentage  ***********************/
	class CoalAttributePercentageBuilderImpl implements CoalAttributePercentage.CoalAttributePercentageBuilder {
	
		protected BigDecimal standardContent;
		protected BigDecimal rejectionLimit;
		
		@Override
		@RosettaAttribute("standardContent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("standardContent")
		public BigDecimal getStandardContent() {
			return standardContent;
		}
		
		@Override
		@RosettaAttribute("rejectionLimit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rejectionLimit")
		public BigDecimal getRejectionLimit() {
			return rejectionLimit;
		}
		
		@RosettaAttribute("standardContent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("standardContent")
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder setStandardContent(BigDecimal _standardContent) {
			this.standardContent = _standardContent == null ? null : _standardContent;
			return this;
		}
		
		@RosettaAttribute("rejectionLimit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rejectionLimit")
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder setRejectionLimit(BigDecimal _rejectionLimit) {
			this.rejectionLimit = _rejectionLimit == null ? null : _rejectionLimit;
			return this;
		}
		
		@Override
		public CoalAttributePercentage build() {
			return new CoalAttributePercentage.CoalAttributePercentageImpl(this);
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardContent()!=null) return true;
			if (getRejectionLimit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalAttributePercentage.CoalAttributePercentageBuilder o = (CoalAttributePercentage.CoalAttributePercentageBuilder) other;
			
			
			merger.mergeBasic(getStandardContent(), o.getStandardContent(), this::setStandardContent);
			merger.mergeBasic(getRejectionLimit(), o.getRejectionLimit(), this::setRejectionLimit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributePercentage _that = getType().cast(o);
		
			if (!Objects.equals(standardContent, _that.getStandardContent())) return false;
			if (!Objects.equals(rejectionLimit, _that.getRejectionLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardContent != null ? standardContent.hashCode() : 0);
			_result = 31 * _result + (rejectionLimit != null ? rejectionLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalAttributePercentageBuilder {" +
				"standardContent=" + this.standardContent + ", " +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}
}
