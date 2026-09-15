package fpml.consolidated.shared;

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
import fpml.consolidated.fpmlenum.RoundingDirectionEnum;
import fpml.consolidated.shared.meta.RoundingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a rounding direction and precision to be used in the rounding of a rate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a rounding direction and precision to be used in the rounding of a rate.
 *
 */
@RosettaDataType(value="Rounding", builder=Rounding.RoundingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Rounding", model="fpml", builder=Rounding.RoundingBuilderImpl.class, version="2.1.1")
public interface Rounding extends RosettaModelObject {

	RoundingMeta metaData = new RoundingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the rounding direction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the rounding direction.
	 *
	 */
	RoundingDirectionEnum getRoundingDirection();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the rounding precision in terms of a number of decimal places. Note how a percentage rate rounding of 5 decimal places is expressed as a rounding precision of 7 in the FpML document since the percentage is expressed as a decimal, e.g. 9.876543% (or 0.09876543) being rounded to the nearest 5 decimal places is 9.87654% (or 0.0987654).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the rounding precision in terms of a number of decimal places. Note how a percentage rate rounding of 5 decimal places is expressed as a rounding precision of 7 in the FpML document since the percentage is expressed as a decimal, e.g. 9.876543% (or 0.09876543) being rounded to the nearest 5 decimal places is 9.87654% (or 0.0987654).
	 *
	 */
	Integer getPrecision();

	/*********************** Build Methods  ***********************/
	Rounding build();
	
	Rounding.RoundingBuilder toBuilder();
	
	static Rounding.RoundingBuilder builder() {
		return new Rounding.RoundingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Rounding> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Rounding> getType() {
		return Rounding.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("roundingDirection"), RoundingDirectionEnum.class, getRoundingDirection(), this);
		processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoundingBuilder extends Rounding, RosettaModelObjectBuilder {
		Rounding.RoundingBuilder setRoundingDirection(RoundingDirectionEnum roundingDirection);
		Rounding.RoundingBuilder setPrecision(Integer precision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("roundingDirection"), RoundingDirectionEnum.class, getRoundingDirection(), this);
			processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
		}
		

		Rounding.RoundingBuilder prune();
	}

	/*********************** Immutable Implementation of Rounding  ***********************/
	class RoundingImpl implements Rounding {
		private final RoundingDirectionEnum roundingDirection;
		private final Integer precision;
		
		protected RoundingImpl(Rounding.RoundingBuilder builder) {
			this.roundingDirection = builder.getRoundingDirection();
			this.precision = builder.getPrecision();
		}
		
		@Override
		@RosettaAttribute("roundingDirection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("roundingDirection")
		public RoundingDirectionEnum getRoundingDirection() {
			return roundingDirection;
		}
		
		@Override
		@RosettaAttribute("precision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@Override
		public Rounding build() {
			return this;
		}
		
		@Override
		public Rounding.RoundingBuilder toBuilder() {
			Rounding.RoundingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Rounding.RoundingBuilder builder) {
			ofNullable(getRoundingDirection()).ifPresent(builder::setRoundingDirection);
			ofNullable(getPrecision()).ifPresent(builder::setPrecision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Rounding _that = getType().cast(o);
		
			if (!Objects.equals(roundingDirection, _that.getRoundingDirection())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (roundingDirection != null ? roundingDirection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Rounding {" +
				"roundingDirection=" + this.roundingDirection + ", " +
				"precision=" + this.precision +
			'}';
		}
	}

	/*********************** Builder Implementation of Rounding  ***********************/
	class RoundingBuilderImpl implements Rounding.RoundingBuilder {
	
		protected RoundingDirectionEnum roundingDirection;
		protected Integer precision;
		
		@Override
		@RosettaAttribute("roundingDirection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("roundingDirection")
		public RoundingDirectionEnum getRoundingDirection() {
			return roundingDirection;
		}
		
		@Override
		@RosettaAttribute("precision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@RosettaAttribute("roundingDirection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("roundingDirection")
		@Override
		public Rounding.RoundingBuilder setRoundingDirection(RoundingDirectionEnum _roundingDirection) {
			this.roundingDirection = _roundingDirection == null ? null : _roundingDirection;
			return this;
		}
		
		@RosettaAttribute("precision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("precision")
		@Override
		public Rounding.RoundingBuilder setPrecision(Integer _precision) {
			this.precision = _precision == null ? null : _precision;
			return this;
		}
		
		@Override
		public Rounding build() {
			return new Rounding.RoundingImpl(this);
		}
		
		@Override
		public Rounding.RoundingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rounding.RoundingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoundingDirection()!=null) return true;
			if (getPrecision()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rounding.RoundingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Rounding.RoundingBuilder o = (Rounding.RoundingBuilder) other;
			
			
			merger.mergeBasic(getRoundingDirection(), o.getRoundingDirection(), this::setRoundingDirection);
			merger.mergeBasic(getPrecision(), o.getPrecision(), this::setPrecision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Rounding _that = getType().cast(o);
		
			if (!Objects.equals(roundingDirection, _that.getRoundingDirection())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (roundingDirection != null ? roundingDirection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoundingBuilder {" +
				"roundingDirection=" + this.roundingDirection + ", " +
				"precision=" + this.precision +
			'}';
		}
	}
}
