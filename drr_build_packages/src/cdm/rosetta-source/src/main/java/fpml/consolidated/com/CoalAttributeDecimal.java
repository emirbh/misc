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
import fpml.consolidated.com.meta.CoalAttributeDecimalMeta;
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
 * Provision The different options for specifying the attributes of a coal quality measure as a decimal value.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The different options for specifying the attributes of a coal quality measure as a decimal value.
 *
 */
@RosettaDataType(value="CoalAttributeDecimal", builder=CoalAttributeDecimal.CoalAttributeDecimalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CoalAttributeDecimal", model="fpml", builder=CoalAttributeDecimal.CoalAttributeDecimalBuilderImpl.class, version="2.1.1")
public interface CoalAttributeDecimal extends RosettaModelObject {

	CoalAttributeDecimalMeta metaData = new CoalAttributeDecimalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The actual content of the quality characteristics of the Coal Product Shipment expected by the Buyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The actual content of the quality characteristics of the Coal Product Shipment expected by the Buyer.
	 *
	 */
	BigDecimal getStandardContent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The actual limits of the quality characteristics of the Coal Product above or below which the Buyer may reject a Shipment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The actual limits of the quality characteristics of the Coal Product above or below which the Buyer may reject a Shipment.
	 *
	 */
	BigDecimal getRejectionLimit();

	/*********************** Build Methods  ***********************/
	CoalAttributeDecimal build();
	
	CoalAttributeDecimal.CoalAttributeDecimalBuilder toBuilder();
	
	static CoalAttributeDecimal.CoalAttributeDecimalBuilder builder() {
		return new CoalAttributeDecimal.CoalAttributeDecimalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalAttributeDecimal> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoalAttributeDecimal> getType() {
		return CoalAttributeDecimal.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardContent"), BigDecimal.class, getStandardContent(), this);
		processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalAttributeDecimalBuilder extends CoalAttributeDecimal, RosettaModelObjectBuilder {
		CoalAttributeDecimal.CoalAttributeDecimalBuilder setStandardContent(BigDecimal standardContent);
		CoalAttributeDecimal.CoalAttributeDecimalBuilder setRejectionLimit(BigDecimal rejectionLimit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardContent"), BigDecimal.class, getStandardContent(), this);
			processor.processBasic(path.newSubPath("rejectionLimit"), BigDecimal.class, getRejectionLimit(), this);
		}
		

		CoalAttributeDecimal.CoalAttributeDecimalBuilder prune();
	}

	/*********************** Immutable Implementation of CoalAttributeDecimal  ***********************/
	class CoalAttributeDecimalImpl implements CoalAttributeDecimal {
		private final BigDecimal standardContent;
		private final BigDecimal rejectionLimit;
		
		protected CoalAttributeDecimalImpl(CoalAttributeDecimal.CoalAttributeDecimalBuilder builder) {
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
		public CoalAttributeDecimal build() {
			return this;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder toBuilder() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalAttributeDecimal.CoalAttributeDecimalBuilder builder) {
			ofNullable(getStandardContent()).ifPresent(builder::setStandardContent);
			ofNullable(getRejectionLimit()).ifPresent(builder::setRejectionLimit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributeDecimal _that = getType().cast(o);
		
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
			return "CoalAttributeDecimal {" +
				"standardContent=" + this.standardContent + ", " +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalAttributeDecimal  ***********************/
	class CoalAttributeDecimalBuilderImpl implements CoalAttributeDecimal.CoalAttributeDecimalBuilder {
	
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
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder setStandardContent(BigDecimal _standardContent) {
			this.standardContent = _standardContent == null ? null : _standardContent;
			return this;
		}
		
		@RosettaAttribute("rejectionLimit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rejectionLimit")
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder setRejectionLimit(BigDecimal _rejectionLimit) {
			this.rejectionLimit = _rejectionLimit == null ? null : _rejectionLimit;
			return this;
		}
		
		@Override
		public CoalAttributeDecimal build() {
			return new CoalAttributeDecimal.CoalAttributeDecimalImpl(this);
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder prune() {
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
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder o = (CoalAttributeDecimal.CoalAttributeDecimalBuilder) other;
			
			
			merger.mergeBasic(getStandardContent(), o.getStandardContent(), this::setStandardContent);
			merger.mergeBasic(getRejectionLimit(), o.getRejectionLimit(), this::setRejectionLimit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalAttributeDecimal _that = getType().cast(o);
		
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
			return "CoalAttributeDecimalBuilder {" +
				"standardContent=" + this.standardContent + ", " +
				"rejectionLimit=" + this.rejectionLimit +
			'}';
		}
	}
}
