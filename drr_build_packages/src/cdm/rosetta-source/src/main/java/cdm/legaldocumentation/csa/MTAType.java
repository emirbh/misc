package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.MTATypeMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Details whether the Minimum Transfer Amount is rating based, a fixed amount, or infinity.
 * @version 6.23.0
 */
@RosettaDataType(value="MTAType", builder=MTAType.MTATypeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MTAType", model="cdm", builder=MTAType.MTATypeBuilderImpl.class, version="6.23.0")
public interface MTAType extends RosettaModelObject {

	MTATypeMeta metaData = new MTATypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines that the Minimum Transfer Amount (MTA) is a Fixed Amount.
	 */
	MTAFixedAmount getFixedAmount();
	/**
	 * Defines that the Minimum Transfer Amount (MTA) is based on a Ratings condition(s).
	 */
	MTARatingsBased getRatingsBased();
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	String getOther();

	/*********************** Build Methods  ***********************/
	MTAType build();
	
	MTAType.MTATypeBuilder toBuilder();
	
	static MTAType.MTATypeBuilder builder() {
		return new MTAType.MTATypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MTAType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MTAType> getType() {
		return MTAType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedAmount"), processor, MTAFixedAmount.class, getFixedAmount());
		processRosetta(path.newSubPath("ratingsBased"), processor, MTARatingsBased.class, getRatingsBased());
		processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MTATypeBuilder extends MTAType, RosettaModelObjectBuilder {
		MTAFixedAmount.MTAFixedAmountBuilder getOrCreateFixedAmount();
		@Override
		MTAFixedAmount.MTAFixedAmountBuilder getFixedAmount();
		MTARatingsBased.MTARatingsBasedBuilder getOrCreateRatingsBased();
		@Override
		MTARatingsBased.MTARatingsBasedBuilder getRatingsBased();
		MTAType.MTATypeBuilder setFixedAmount(MTAFixedAmount fixedAmount);
		MTAType.MTATypeBuilder setRatingsBased(MTARatingsBased ratingsBased);
		MTAType.MTATypeBuilder setOther(String other);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedAmount"), processor, MTAFixedAmount.MTAFixedAmountBuilder.class, getFixedAmount());
			processRosetta(path.newSubPath("ratingsBased"), processor, MTARatingsBased.MTARatingsBasedBuilder.class, getRatingsBased());
			processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
		}
		

		MTAType.MTATypeBuilder prune();
	}

	/*********************** Immutable Implementation of MTAType  ***********************/
	class MTATypeImpl implements MTAType {
		private final MTAFixedAmount fixedAmount;
		private final MTARatingsBased ratingsBased;
		private final String other;
		
		protected MTATypeImpl(MTAType.MTATypeBuilder builder) {
			this.fixedAmount = ofNullable(builder.getFixedAmount()).map(f->f.build()).orElse(null);
			this.ratingsBased = ofNullable(builder.getRatingsBased()).map(f->f.build()).orElse(null);
			this.other = builder.getOther();
		}
		
		@Override
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedAmount")
		public MTAFixedAmount getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		@RosettaAttribute("ratingsBased")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratingsBased")
		public MTARatingsBased getRatingsBased() {
			return ratingsBased;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("other")
		public String getOther() {
			return other;
		}
		
		@Override
		public MTAType build() {
			return this;
		}
		
		@Override
		public MTAType.MTATypeBuilder toBuilder() {
			MTAType.MTATypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MTAType.MTATypeBuilder builder) {
			ofNullable(getFixedAmount()).ifPresent(builder::setFixedAmount);
			ofNullable(getRatingsBased()).ifPresent(builder::setRatingsBased);
			ofNullable(getOther()).ifPresent(builder::setOther);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MTAType _that = getType().cast(o);
		
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			if (!Objects.equals(ratingsBased, _that.getRatingsBased())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			_result = 31 * _result + (ratingsBased != null ? ratingsBased.hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MTAType {" +
				"fixedAmount=" + this.fixedAmount + ", " +
				"ratingsBased=" + this.ratingsBased + ", " +
				"other=" + this.other +
			'}';
		}
	}

	/*********************** Builder Implementation of MTAType  ***********************/
	class MTATypeBuilderImpl implements MTAType.MTATypeBuilder {
	
		protected MTAFixedAmount.MTAFixedAmountBuilder fixedAmount;
		protected MTARatingsBased.MTARatingsBasedBuilder ratingsBased;
		protected String other;
		
		@Override
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedAmount")
		public MTAFixedAmount.MTAFixedAmountBuilder getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		public MTAFixedAmount.MTAFixedAmountBuilder getOrCreateFixedAmount() {
			MTAFixedAmount.MTAFixedAmountBuilder result;
			if (fixedAmount!=null) {
				result = fixedAmount;
			}
			else {
				result = fixedAmount = MTAFixedAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ratingsBased")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratingsBased")
		public MTARatingsBased.MTARatingsBasedBuilder getRatingsBased() {
			return ratingsBased;
		}
		
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder getOrCreateRatingsBased() {
			MTARatingsBased.MTARatingsBasedBuilder result;
			if (ratingsBased!=null) {
				result = ratingsBased;
			}
			else {
				result = ratingsBased = MTARatingsBased.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("other")
		public String getOther() {
			return other;
		}
		
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedAmount")
		@Override
		public MTAType.MTATypeBuilder setFixedAmount(MTAFixedAmount _fixedAmount) {
			this.fixedAmount = _fixedAmount == null ? null : _fixedAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ratingsBased")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ratingsBased")
		@Override
		public MTAType.MTATypeBuilder setRatingsBased(MTARatingsBased _ratingsBased) {
			this.ratingsBased = _ratingsBased == null ? null : _ratingsBased.toBuilder();
			return this;
		}
		
		@RosettaAttribute("other")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("other")
		@Override
		public MTAType.MTATypeBuilder setOther(String _other) {
			this.other = _other == null ? null : _other;
			return this;
		}
		
		@Override
		public MTAType build() {
			return new MTAType.MTATypeImpl(this);
		}
		
		@Override
		public MTAType.MTATypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MTAType.MTATypeBuilder prune() {
			if (fixedAmount!=null && !fixedAmount.prune().hasData()) fixedAmount = null;
			if (ratingsBased!=null && !ratingsBased.prune().hasData()) ratingsBased = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedAmount()!=null && getFixedAmount().hasData()) return true;
			if (getRatingsBased()!=null && getRatingsBased().hasData()) return true;
			if (getOther()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MTAType.MTATypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MTAType.MTATypeBuilder o = (MTAType.MTATypeBuilder) other;
			
			merger.mergeRosetta(getFixedAmount(), o.getFixedAmount(), this::setFixedAmount);
			merger.mergeRosetta(getRatingsBased(), o.getRatingsBased(), this::setRatingsBased);
			
			merger.mergeBasic(getOther(), o.getOther(), this::setOther);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MTAType _that = getType().cast(o);
		
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			if (!Objects.equals(ratingsBased, _that.getRatingsBased())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			_result = 31 * _result + (ratingsBased != null ? ratingsBased.hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MTATypeBuilder {" +
				"fixedAmount=" + this.fixedAmount + ", " +
				"ratingsBased=" + this.ratingsBased + ", " +
				"other=" + this.other +
			'}';
		}
	}
}
