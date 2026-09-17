package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.ThresholdTypeMeta;
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
 * Details whether the threshold is rating based, a fixed amount, or infinity.
 * @version 6.23.0
 */
@RosettaDataType(value="ThresholdType", builder=ThresholdType.ThresholdTypeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ThresholdType", model="cdm", builder=ThresholdType.ThresholdTypeBuilderImpl.class, version="6.23.0")
public interface ThresholdType extends RosettaModelObject {

	ThresholdTypeMeta metaData = new ThresholdTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines that the Threshold is a Fixed Amount.
	 */
	ThresholdFixedAmount getFixedAmount();
	/**
	 * Defines that the Threshold is based on a Ratings condition(s).
	 */
	ThresholdRatingsBased getRatingsBased();
	/**
	 * Defines that the Threshold is Infinity.
	 */
	Infinity getInfinity();
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	String getOther();

	/*********************** Build Methods  ***********************/
	ThresholdType build();
	
	ThresholdType.ThresholdTypeBuilder toBuilder();
	
	static ThresholdType.ThresholdTypeBuilder builder() {
		return new ThresholdType.ThresholdTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ThresholdType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ThresholdType> getType() {
		return ThresholdType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedAmount"), processor, ThresholdFixedAmount.class, getFixedAmount());
		processRosetta(path.newSubPath("ratingsBased"), processor, ThresholdRatingsBased.class, getRatingsBased());
		processRosetta(path.newSubPath("infinity"), processor, Infinity.class, getInfinity());
		processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ThresholdTypeBuilder extends ThresholdType, RosettaModelObjectBuilder {
		ThresholdFixedAmount.ThresholdFixedAmountBuilder getOrCreateFixedAmount();
		@Override
		ThresholdFixedAmount.ThresholdFixedAmountBuilder getFixedAmount();
		ThresholdRatingsBased.ThresholdRatingsBasedBuilder getOrCreateRatingsBased();
		@Override
		ThresholdRatingsBased.ThresholdRatingsBasedBuilder getRatingsBased();
		Infinity.InfinityBuilder getOrCreateInfinity();
		@Override
		Infinity.InfinityBuilder getInfinity();
		ThresholdType.ThresholdTypeBuilder setFixedAmount(ThresholdFixedAmount fixedAmount);
		ThresholdType.ThresholdTypeBuilder setRatingsBased(ThresholdRatingsBased ratingsBased);
		ThresholdType.ThresholdTypeBuilder setInfinity(Infinity infinity);
		ThresholdType.ThresholdTypeBuilder setOther(String other);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedAmount"), processor, ThresholdFixedAmount.ThresholdFixedAmountBuilder.class, getFixedAmount());
			processRosetta(path.newSubPath("ratingsBased"), processor, ThresholdRatingsBased.ThresholdRatingsBasedBuilder.class, getRatingsBased());
			processRosetta(path.newSubPath("infinity"), processor, Infinity.InfinityBuilder.class, getInfinity());
			processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
		}
		

		ThresholdType.ThresholdTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ThresholdType  ***********************/
	class ThresholdTypeImpl implements ThresholdType {
		private final ThresholdFixedAmount fixedAmount;
		private final ThresholdRatingsBased ratingsBased;
		private final Infinity infinity;
		private final String other;
		
		protected ThresholdTypeImpl(ThresholdType.ThresholdTypeBuilder builder) {
			this.fixedAmount = ofNullable(builder.getFixedAmount()).map(f->f.build()).orElse(null);
			this.ratingsBased = ofNullable(builder.getRatingsBased()).map(f->f.build()).orElse(null);
			this.infinity = ofNullable(builder.getInfinity()).map(f->f.build()).orElse(null);
			this.other = builder.getOther();
		}
		
		@Override
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedAmount")
		public ThresholdFixedAmount getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		@RosettaAttribute("ratingsBased")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratingsBased")
		public ThresholdRatingsBased getRatingsBased() {
			return ratingsBased;
		}
		
		@Override
		@RosettaAttribute("infinity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("infinity")
		public Infinity getInfinity() {
			return infinity;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("other")
		public String getOther() {
			return other;
		}
		
		@Override
		public ThresholdType build() {
			return this;
		}
		
		@Override
		public ThresholdType.ThresholdTypeBuilder toBuilder() {
			ThresholdType.ThresholdTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ThresholdType.ThresholdTypeBuilder builder) {
			ofNullable(getFixedAmount()).ifPresent(builder::setFixedAmount);
			ofNullable(getRatingsBased()).ifPresent(builder::setRatingsBased);
			ofNullable(getInfinity()).ifPresent(builder::setInfinity);
			ofNullable(getOther()).ifPresent(builder::setOther);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ThresholdType _that = getType().cast(o);
		
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			if (!Objects.equals(ratingsBased, _that.getRatingsBased())) return false;
			if (!Objects.equals(infinity, _that.getInfinity())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			_result = 31 * _result + (ratingsBased != null ? ratingsBased.hashCode() : 0);
			_result = 31 * _result + (infinity != null ? infinity.hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ThresholdType {" +
				"fixedAmount=" + this.fixedAmount + ", " +
				"ratingsBased=" + this.ratingsBased + ", " +
				"infinity=" + this.infinity + ", " +
				"other=" + this.other +
			'}';
		}
	}

	/*********************** Builder Implementation of ThresholdType  ***********************/
	class ThresholdTypeBuilderImpl implements ThresholdType.ThresholdTypeBuilder {
	
		protected ThresholdFixedAmount.ThresholdFixedAmountBuilder fixedAmount;
		protected ThresholdRatingsBased.ThresholdRatingsBasedBuilder ratingsBased;
		protected Infinity.InfinityBuilder infinity;
		protected String other;
		
		@Override
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedAmount")
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		public ThresholdFixedAmount.ThresholdFixedAmountBuilder getOrCreateFixedAmount() {
			ThresholdFixedAmount.ThresholdFixedAmountBuilder result;
			if (fixedAmount!=null) {
				result = fixedAmount;
			}
			else {
				result = fixedAmount = ThresholdFixedAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ratingsBased")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratingsBased")
		public ThresholdRatingsBased.ThresholdRatingsBasedBuilder getRatingsBased() {
			return ratingsBased;
		}
		
		@Override
		public ThresholdRatingsBased.ThresholdRatingsBasedBuilder getOrCreateRatingsBased() {
			ThresholdRatingsBased.ThresholdRatingsBasedBuilder result;
			if (ratingsBased!=null) {
				result = ratingsBased;
			}
			else {
				result = ratingsBased = ThresholdRatingsBased.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("infinity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("infinity")
		public Infinity.InfinityBuilder getInfinity() {
			return infinity;
		}
		
		@Override
		public Infinity.InfinityBuilder getOrCreateInfinity() {
			Infinity.InfinityBuilder result;
			if (infinity!=null) {
				result = infinity;
			}
			else {
				result = infinity = Infinity.builder();
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
		public ThresholdType.ThresholdTypeBuilder setFixedAmount(ThresholdFixedAmount _fixedAmount) {
			this.fixedAmount = _fixedAmount == null ? null : _fixedAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ratingsBased")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ratingsBased")
		@Override
		public ThresholdType.ThresholdTypeBuilder setRatingsBased(ThresholdRatingsBased _ratingsBased) {
			this.ratingsBased = _ratingsBased == null ? null : _ratingsBased.toBuilder();
			return this;
		}
		
		@RosettaAttribute("infinity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("infinity")
		@Override
		public ThresholdType.ThresholdTypeBuilder setInfinity(Infinity _infinity) {
			this.infinity = _infinity == null ? null : _infinity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("other")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("other")
		@Override
		public ThresholdType.ThresholdTypeBuilder setOther(String _other) {
			this.other = _other == null ? null : _other;
			return this;
		}
		
		@Override
		public ThresholdType build() {
			return new ThresholdType.ThresholdTypeImpl(this);
		}
		
		@Override
		public ThresholdType.ThresholdTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ThresholdType.ThresholdTypeBuilder prune() {
			if (fixedAmount!=null && !fixedAmount.prune().hasData()) fixedAmount = null;
			if (ratingsBased!=null && !ratingsBased.prune().hasData()) ratingsBased = null;
			if (infinity!=null && !infinity.prune().hasData()) infinity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedAmount()!=null && getFixedAmount().hasData()) return true;
			if (getRatingsBased()!=null && getRatingsBased().hasData()) return true;
			if (getInfinity()!=null && getInfinity().hasData()) return true;
			if (getOther()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ThresholdType.ThresholdTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ThresholdType.ThresholdTypeBuilder o = (ThresholdType.ThresholdTypeBuilder) other;
			
			merger.mergeRosetta(getFixedAmount(), o.getFixedAmount(), this::setFixedAmount);
			merger.mergeRosetta(getRatingsBased(), o.getRatingsBased(), this::setRatingsBased);
			merger.mergeRosetta(getInfinity(), o.getInfinity(), this::setInfinity);
			
			merger.mergeBasic(getOther(), o.getOther(), this::setOther);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ThresholdType _that = getType().cast(o);
		
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			if (!Objects.equals(ratingsBased, _that.getRatingsBased())) return false;
			if (!Objects.equals(infinity, _that.getInfinity())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			_result = 31 * _result + (ratingsBased != null ? ratingsBased.hashCode() : 0);
			_result = 31 * _result + (infinity != null ? infinity.hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ThresholdTypeBuilder {" +
				"fixedAmount=" + this.fixedAmount + ", " +
				"ratingsBased=" + this.ratingsBased + ", " +
				"infinity=" + this.infinity + ", " +
				"other=" + this.other +
			'}';
		}
	}
}
