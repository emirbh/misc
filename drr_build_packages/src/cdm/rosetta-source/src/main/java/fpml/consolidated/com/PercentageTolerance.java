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
import fpml.consolidated.com.meta.PercentageToleranceMeta;
import fpml.consolidated.shared.PartyReference;
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
 * Provision The acceptable tolerance in the delivered quantity of a physical commodity product in terms of a percentage of the agreed delivery quantity.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The acceptable tolerance in the delivered quantity of a physical commodity product in terms of a percentage of the agreed delivery quantity.
 *
 */
@RosettaDataType(value="PercentageTolerance", builder=PercentageTolerance.PercentageToleranceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PercentageTolerance", model="fpml", builder=PercentageTolerance.PercentageToleranceBuilderImpl.class, version="2.1.1")
public interface PercentageTolerance extends RosettaModelObject {

	PercentageToleranceMeta metaData = new PercentageToleranceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The maximum percentage amount by which the quantity delivered can exceed the agreed quantity. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maximum percentage amount by which the quantity delivered can exceed the agreed quantity. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getPostitive();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The maximum percentage amount by which the quantity delivered can be less than the agreed quantity. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maximum percentage amount by which the quantity delivered can be less than the agreed quantity. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getNegative();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether the tolerance it at the seller's or buyer's option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether the tolerance it at the seller's or buyer's option.
	 *
	 */
	PartyReference getOption();

	/*********************** Build Methods  ***********************/
	PercentageTolerance build();
	
	PercentageTolerance.PercentageToleranceBuilder toBuilder();
	
	static PercentageTolerance.PercentageToleranceBuilder builder() {
		return new PercentageTolerance.PercentageToleranceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PercentageTolerance> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PercentageTolerance> getType() {
		return PercentageTolerance.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("postitive"), BigDecimal.class, getPostitive(), this);
		processor.processBasic(path.newSubPath("negative"), BigDecimal.class, getNegative(), this);
		processRosetta(path.newSubPath("option"), processor, PartyReference.class, getOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PercentageToleranceBuilder extends PercentageTolerance, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateOption();
		@Override
		PartyReference.PartyReferenceBuilder getOption();
		PercentageTolerance.PercentageToleranceBuilder setPostitive(BigDecimal postitive);
		PercentageTolerance.PercentageToleranceBuilder setNegative(BigDecimal negative);
		PercentageTolerance.PercentageToleranceBuilder setOption(PartyReference option);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("postitive"), BigDecimal.class, getPostitive(), this);
			processor.processBasic(path.newSubPath("negative"), BigDecimal.class, getNegative(), this);
			processRosetta(path.newSubPath("option"), processor, PartyReference.PartyReferenceBuilder.class, getOption());
		}
		

		PercentageTolerance.PercentageToleranceBuilder prune();
	}

	/*********************** Immutable Implementation of PercentageTolerance  ***********************/
	class PercentageToleranceImpl implements PercentageTolerance {
		private final BigDecimal postitive;
		private final BigDecimal negative;
		private final PartyReference option;
		
		protected PercentageToleranceImpl(PercentageTolerance.PercentageToleranceBuilder builder) {
			this.postitive = builder.getPostitive();
			this.negative = builder.getNegative();
			this.option = ofNullable(builder.getOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("postitive")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postitive")
		public BigDecimal getPostitive() {
			return postitive;
		}
		
		@Override
		@RosettaAttribute("negative")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("negative")
		public BigDecimal getNegative() {
			return negative;
		}
		
		@Override
		@RosettaAttribute("option")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("option")
		public PartyReference getOption() {
			return option;
		}
		
		@Override
		public PercentageTolerance build() {
			return this;
		}
		
		@Override
		public PercentageTolerance.PercentageToleranceBuilder toBuilder() {
			PercentageTolerance.PercentageToleranceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PercentageTolerance.PercentageToleranceBuilder builder) {
			ofNullable(getPostitive()).ifPresent(builder::setPostitive);
			ofNullable(getNegative()).ifPresent(builder::setNegative);
			ofNullable(getOption()).ifPresent(builder::setOption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PercentageTolerance _that = getType().cast(o);
		
			if (!Objects.equals(postitive, _that.getPostitive())) return false;
			if (!Objects.equals(negative, _that.getNegative())) return false;
			if (!Objects.equals(option, _that.getOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (postitive != null ? postitive.hashCode() : 0);
			_result = 31 * _result + (negative != null ? negative.hashCode() : 0);
			_result = 31 * _result + (option != null ? option.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PercentageTolerance {" +
				"postitive=" + this.postitive + ", " +
				"negative=" + this.negative + ", " +
				"option=" + this.option +
			'}';
		}
	}

	/*********************** Builder Implementation of PercentageTolerance  ***********************/
	class PercentageToleranceBuilderImpl implements PercentageTolerance.PercentageToleranceBuilder {
	
		protected BigDecimal postitive;
		protected BigDecimal negative;
		protected PartyReference.PartyReferenceBuilder option;
		
		@Override
		@RosettaAttribute("postitive")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postitive")
		public BigDecimal getPostitive() {
			return postitive;
		}
		
		@Override
		@RosettaAttribute("negative")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("negative")
		public BigDecimal getNegative() {
			return negative;
		}
		
		@Override
		@RosettaAttribute("option")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("option")
		public PartyReference.PartyReferenceBuilder getOption() {
			return option;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOption() {
			PartyReference.PartyReferenceBuilder result;
			if (option!=null) {
				result = option;
			}
			else {
				result = option = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("postitive")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postitive")
		@Override
		public PercentageTolerance.PercentageToleranceBuilder setPostitive(BigDecimal _postitive) {
			this.postitive = _postitive == null ? null : _postitive;
			return this;
		}
		
		@RosettaAttribute("negative")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("negative")
		@Override
		public PercentageTolerance.PercentageToleranceBuilder setNegative(BigDecimal _negative) {
			this.negative = _negative == null ? null : _negative;
			return this;
		}
		
		@RosettaAttribute("option")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("option")
		@Override
		public PercentageTolerance.PercentageToleranceBuilder setOption(PartyReference _option) {
			this.option = _option == null ? null : _option.toBuilder();
			return this;
		}
		
		@Override
		public PercentageTolerance build() {
			return new PercentageTolerance.PercentageToleranceImpl(this);
		}
		
		@Override
		public PercentageTolerance.PercentageToleranceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PercentageTolerance.PercentageToleranceBuilder prune() {
			if (option!=null && !option.prune().hasData()) option = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPostitive()!=null) return true;
			if (getNegative()!=null) return true;
			if (getOption()!=null && getOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PercentageTolerance.PercentageToleranceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PercentageTolerance.PercentageToleranceBuilder o = (PercentageTolerance.PercentageToleranceBuilder) other;
			
			merger.mergeRosetta(getOption(), o.getOption(), this::setOption);
			
			merger.mergeBasic(getPostitive(), o.getPostitive(), this::setPostitive);
			merger.mergeBasic(getNegative(), o.getNegative(), this::setNegative);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PercentageTolerance _that = getType().cast(o);
		
			if (!Objects.equals(postitive, _that.getPostitive())) return false;
			if (!Objects.equals(negative, _that.getNegative())) return false;
			if (!Objects.equals(option, _that.getOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (postitive != null ? postitive.hashCode() : 0);
			_result = 31 * _result + (negative != null ? negative.hashCode() : 0);
			_result = 31 * _result + (option != null ? option.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PercentageToleranceBuilder {" +
				"postitive=" + this.postitive + ", " +
				"negative=" + this.negative + ", " +
				"option=" + this.option +
			'}';
		}
	}
}
