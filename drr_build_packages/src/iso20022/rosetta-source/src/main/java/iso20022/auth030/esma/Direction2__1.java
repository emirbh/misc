package iso20022.auth030.esma;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.esma.meta.Direction2__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Elements indicating the direction of the derivative transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="Direction2__1", builder=Direction2__1.Direction2__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Direction2__1", model="iso20022", builder=Direction2__1.Direction2__1BuilderImpl.class, version="${project.version}")
public interface Direction2__1 extends RosettaModelObject {

	Direction2__1Meta metaData = new Direction2__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies whether the reporting counterparty is the payer (Taker) or the receiver (Maker) of the first leg as determined at the time of transaction.
	 */
	OptionParty3Code getDrctnOfTheFrstLeg();
	/**
	 * Identifies whether the reporting counterparty is the payer (Taker) or the receiver (Maker) of the second leg as determined at the time of transaction.
	 */
	OptionParty3Code getDrctnOfTheScndLeg();

	/*********************** Build Methods  ***********************/
	Direction2__1 build();
	
	Direction2__1.Direction2__1Builder toBuilder();
	
	static Direction2__1.Direction2__1Builder builder() {
		return new Direction2__1.Direction2__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Direction2__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Direction2__1> getType() {
		return Direction2__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("drctnOfTheFrstLeg"), OptionParty3Code.class, getDrctnOfTheFrstLeg(), this);
		processor.processBasic(path.newSubPath("drctnOfTheScndLeg"), OptionParty3Code.class, getDrctnOfTheScndLeg(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Direction2__1Builder extends Direction2__1, RosettaModelObjectBuilder {
		Direction2__1.Direction2__1Builder setDrctnOfTheFrstLeg(OptionParty3Code drctnOfTheFrstLeg);
		Direction2__1.Direction2__1Builder setDrctnOfTheScndLeg(OptionParty3Code drctnOfTheScndLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("drctnOfTheFrstLeg"), OptionParty3Code.class, getDrctnOfTheFrstLeg(), this);
			processor.processBasic(path.newSubPath("drctnOfTheScndLeg"), OptionParty3Code.class, getDrctnOfTheScndLeg(), this);
		}
		

		Direction2__1.Direction2__1Builder prune();
	}

	/*********************** Immutable Implementation of Direction2__1  ***********************/
	class Direction2__1Impl implements Direction2__1 {
		private final OptionParty3Code drctnOfTheFrstLeg;
		private final OptionParty3Code drctnOfTheScndLeg;
		
		protected Direction2__1Impl(Direction2__1.Direction2__1Builder builder) {
			this.drctnOfTheFrstLeg = builder.getDrctnOfTheFrstLeg();
			this.drctnOfTheScndLeg = builder.getDrctnOfTheScndLeg();
		}
		
		@Override
		@RosettaAttribute("drctnOfTheFrstLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("drctnOfTheFrstLeg")
		public OptionParty3Code getDrctnOfTheFrstLeg() {
			return drctnOfTheFrstLeg;
		}
		
		@Override
		@RosettaAttribute("drctnOfTheScndLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("drctnOfTheScndLeg")
		public OptionParty3Code getDrctnOfTheScndLeg() {
			return drctnOfTheScndLeg;
		}
		
		@Override
		public Direction2__1 build() {
			return this;
		}
		
		@Override
		public Direction2__1.Direction2__1Builder toBuilder() {
			Direction2__1.Direction2__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Direction2__1.Direction2__1Builder builder) {
			ofNullable(getDrctnOfTheFrstLeg()).ifPresent(builder::setDrctnOfTheFrstLeg);
			ofNullable(getDrctnOfTheScndLeg()).ifPresent(builder::setDrctnOfTheScndLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Direction2__1 _that = getType().cast(o);
		
			if (!Objects.equals(drctnOfTheFrstLeg, _that.getDrctnOfTheFrstLeg())) return false;
			if (!Objects.equals(drctnOfTheScndLeg, _that.getDrctnOfTheScndLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (drctnOfTheFrstLeg != null ? drctnOfTheFrstLeg.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (drctnOfTheScndLeg != null ? drctnOfTheScndLeg.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Direction2__1 {" +
				"drctnOfTheFrstLeg=" + this.drctnOfTheFrstLeg + ", " +
				"drctnOfTheScndLeg=" + this.drctnOfTheScndLeg +
			'}';
		}
	}

	/*********************** Builder Implementation of Direction2__1  ***********************/
	class Direction2__1BuilderImpl implements Direction2__1.Direction2__1Builder {
	
		protected OptionParty3Code drctnOfTheFrstLeg;
		protected OptionParty3Code drctnOfTheScndLeg;
		
		@Override
		@RosettaAttribute("drctnOfTheFrstLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("drctnOfTheFrstLeg")
		public OptionParty3Code getDrctnOfTheFrstLeg() {
			return drctnOfTheFrstLeg;
		}
		
		@Override
		@RosettaAttribute("drctnOfTheScndLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("drctnOfTheScndLeg")
		public OptionParty3Code getDrctnOfTheScndLeg() {
			return drctnOfTheScndLeg;
		}
		
		@RosettaAttribute("drctnOfTheFrstLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("drctnOfTheFrstLeg")
		@Override
		public Direction2__1.Direction2__1Builder setDrctnOfTheFrstLeg(OptionParty3Code _drctnOfTheFrstLeg) {
			this.drctnOfTheFrstLeg = _drctnOfTheFrstLeg == null ? null : _drctnOfTheFrstLeg;
			return this;
		}
		
		@RosettaAttribute("drctnOfTheScndLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("drctnOfTheScndLeg")
		@Override
		public Direction2__1.Direction2__1Builder setDrctnOfTheScndLeg(OptionParty3Code _drctnOfTheScndLeg) {
			this.drctnOfTheScndLeg = _drctnOfTheScndLeg == null ? null : _drctnOfTheScndLeg;
			return this;
		}
		
		@Override
		public Direction2__1 build() {
			return new Direction2__1.Direction2__1Impl(this);
		}
		
		@Override
		public Direction2__1.Direction2__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Direction2__1.Direction2__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDrctnOfTheFrstLeg()!=null) return true;
			if (getDrctnOfTheScndLeg()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Direction2__1.Direction2__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Direction2__1.Direction2__1Builder o = (Direction2__1.Direction2__1Builder) other;
			
			
			merger.mergeBasic(getDrctnOfTheFrstLeg(), o.getDrctnOfTheFrstLeg(), this::setDrctnOfTheFrstLeg);
			merger.mergeBasic(getDrctnOfTheScndLeg(), o.getDrctnOfTheScndLeg(), this::setDrctnOfTheScndLeg);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Direction2__1 _that = getType().cast(o);
		
			if (!Objects.equals(drctnOfTheFrstLeg, _that.getDrctnOfTheFrstLeg())) return false;
			if (!Objects.equals(drctnOfTheScndLeg, _that.getDrctnOfTheScndLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (drctnOfTheFrstLeg != null ? drctnOfTheFrstLeg.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (drctnOfTheScndLeg != null ? drctnOfTheScndLeg.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Direction2__1Builder {" +
				"drctnOfTheFrstLeg=" + this.drctnOfTheFrstLeg + ", " +
				"drctnOfTheScndLeg=" + this.drctnOfTheScndLeg +
			'}';
		}
	}
}
