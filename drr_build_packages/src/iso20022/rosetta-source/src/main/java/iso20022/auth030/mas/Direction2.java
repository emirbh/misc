package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.Direction2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Direction2", builder=Direction2.Direction2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Direction2", model="iso20022", builder=Direction2.Direction2BuilderImpl.class, version="${project.version}")
public interface Direction2 extends RosettaModelObject {

	Direction2Meta metaData = new Direction2Meta();

	/*********************** Getter Methods  ***********************/
	OptionParty3Code getDrctnOfTheFrstLeg();
	OptionParty3Code getDrctnOfTheScndLeg();

	/*********************** Build Methods  ***********************/
	Direction2 build();
	
	Direction2.Direction2Builder toBuilder();
	
	static Direction2.Direction2Builder builder() {
		return new Direction2.Direction2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Direction2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Direction2> getType() {
		return Direction2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("drctnOfTheFrstLeg"), OptionParty3Code.class, getDrctnOfTheFrstLeg(), this);
		processor.processBasic(path.newSubPath("drctnOfTheScndLeg"), OptionParty3Code.class, getDrctnOfTheScndLeg(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Direction2Builder extends Direction2, RosettaModelObjectBuilder {
		Direction2.Direction2Builder setDrctnOfTheFrstLeg(OptionParty3Code drctnOfTheFrstLeg);
		Direction2.Direction2Builder setDrctnOfTheScndLeg(OptionParty3Code drctnOfTheScndLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("drctnOfTheFrstLeg"), OptionParty3Code.class, getDrctnOfTheFrstLeg(), this);
			processor.processBasic(path.newSubPath("drctnOfTheScndLeg"), OptionParty3Code.class, getDrctnOfTheScndLeg(), this);
		}
		

		Direction2.Direction2Builder prune();
	}

	/*********************** Immutable Implementation of Direction2  ***********************/
	class Direction2Impl implements Direction2 {
		private final OptionParty3Code drctnOfTheFrstLeg;
		private final OptionParty3Code drctnOfTheScndLeg;
		
		protected Direction2Impl(Direction2.Direction2Builder builder) {
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
		@RuneAttribute("drctnOfTheScndLeg")
		public OptionParty3Code getDrctnOfTheScndLeg() {
			return drctnOfTheScndLeg;
		}
		
		@Override
		public Direction2 build() {
			return this;
		}
		
		@Override
		public Direction2.Direction2Builder toBuilder() {
			Direction2.Direction2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Direction2.Direction2Builder builder) {
			ofNullable(getDrctnOfTheFrstLeg()).ifPresent(builder::setDrctnOfTheFrstLeg);
			ofNullable(getDrctnOfTheScndLeg()).ifPresent(builder::setDrctnOfTheScndLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Direction2 _that = getType().cast(o);
		
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
			return "Direction2 {" +
				"drctnOfTheFrstLeg=" + this.drctnOfTheFrstLeg + ", " +
				"drctnOfTheScndLeg=" + this.drctnOfTheScndLeg +
			'}';
		}
	}

	/*********************** Builder Implementation of Direction2  ***********************/
	class Direction2BuilderImpl implements Direction2.Direction2Builder {
	
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
		@RuneAttribute("drctnOfTheScndLeg")
		public OptionParty3Code getDrctnOfTheScndLeg() {
			return drctnOfTheScndLeg;
		}
		
		@RosettaAttribute("drctnOfTheFrstLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("drctnOfTheFrstLeg")
		@Override
		public Direction2.Direction2Builder setDrctnOfTheFrstLeg(OptionParty3Code _drctnOfTheFrstLeg) {
			this.drctnOfTheFrstLeg = _drctnOfTheFrstLeg == null ? null : _drctnOfTheFrstLeg;
			return this;
		}
		
		@RosettaAttribute("drctnOfTheScndLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("drctnOfTheScndLeg")
		@Override
		public Direction2.Direction2Builder setDrctnOfTheScndLeg(OptionParty3Code _drctnOfTheScndLeg) {
			this.drctnOfTheScndLeg = _drctnOfTheScndLeg == null ? null : _drctnOfTheScndLeg;
			return this;
		}
		
		@Override
		public Direction2 build() {
			return new Direction2.Direction2Impl(this);
		}
		
		@Override
		public Direction2.Direction2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Direction2.Direction2Builder prune() {
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
		public Direction2.Direction2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Direction2.Direction2Builder o = (Direction2.Direction2Builder) other;
			
			
			merger.mergeBasic(getDrctnOfTheFrstLeg(), o.getDrctnOfTheFrstLeg(), this::setDrctnOfTheFrstLeg);
			merger.mergeBasic(getDrctnOfTheScndLeg(), o.getDrctnOfTheScndLeg(), this::setDrctnOfTheScndLeg);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Direction2 _that = getType().cast(o);
		
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
			return "Direction2Builder {" +
				"drctnOfTheFrstLeg=" + this.drctnOfTheFrstLeg + ", " +
				"drctnOfTheScndLeg=" + this.drctnOfTheScndLeg +
			'}';
		}
	}
}
