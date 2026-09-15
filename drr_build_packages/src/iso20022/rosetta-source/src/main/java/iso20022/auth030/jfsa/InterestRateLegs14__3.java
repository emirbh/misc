package iso20022.auth030.jfsa;

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
import iso20022.auth030.jfsa.meta.InterestRateLegs14__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestRateLegs14__3", builder=InterestRateLegs14__3.InterestRateLegs14__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InterestRateLegs14__3", model="iso20022", builder=InterestRateLegs14__3.InterestRateLegs14__3BuilderImpl.class, version="${project.version}")
public interface InterestRateLegs14__3 extends RosettaModelObject {

	InterestRateLegs14__3Meta metaData = new InterestRateLegs14__3Meta();

	/*********************** Getter Methods  ***********************/
	InterestRate33Choice__3 getFrstLeg();
	InterestRate33Choice__1 getScndLeg();

	/*********************** Build Methods  ***********************/
	InterestRateLegs14__3 build();
	
	InterestRateLegs14__3.InterestRateLegs14__3Builder toBuilder();
	
	static InterestRateLegs14__3.InterestRateLegs14__3Builder builder() {
		return new InterestRateLegs14__3.InterestRateLegs14__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateLegs14__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestRateLegs14__3> getType() {
		return InterestRateLegs14__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("frstLeg"), processor, InterestRate33Choice__3.class, getFrstLeg());
		processRosetta(path.newSubPath("scndLeg"), processor, InterestRate33Choice__1.class, getScndLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateLegs14__3Builder extends InterestRateLegs14__3, RosettaModelObjectBuilder {
		InterestRate33Choice__3.InterestRate33Choice__3Builder getOrCreateFrstLeg();
		@Override
		InterestRate33Choice__3.InterestRate33Choice__3Builder getFrstLeg();
		InterestRate33Choice__1.InterestRate33Choice__1Builder getOrCreateScndLeg();
		@Override
		InterestRate33Choice__1.InterestRate33Choice__1Builder getScndLeg();
		InterestRateLegs14__3.InterestRateLegs14__3Builder setFrstLeg(InterestRate33Choice__3 frstLeg);
		InterestRateLegs14__3.InterestRateLegs14__3Builder setScndLeg(InterestRate33Choice__1 scndLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("frstLeg"), processor, InterestRate33Choice__3.InterestRate33Choice__3Builder.class, getFrstLeg());
			processRosetta(path.newSubPath("scndLeg"), processor, InterestRate33Choice__1.InterestRate33Choice__1Builder.class, getScndLeg());
		}
		

		InterestRateLegs14__3.InterestRateLegs14__3Builder prune();
	}

	/*********************** Immutable Implementation of InterestRateLegs14__3  ***********************/
	class InterestRateLegs14__3Impl implements InterestRateLegs14__3 {
		private final InterestRate33Choice__3 frstLeg;
		private final InterestRate33Choice__1 scndLeg;
		
		protected InterestRateLegs14__3Impl(InterestRateLegs14__3.InterestRateLegs14__3Builder builder) {
			this.frstLeg = ofNullable(builder.getFrstLeg()).map(f->f.build()).orElse(null);
			this.scndLeg = ofNullable(builder.getScndLeg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstLeg")
		public InterestRate33Choice__3 getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public InterestRate33Choice__1 getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public InterestRateLegs14__3 build() {
			return this;
		}
		
		@Override
		public InterestRateLegs14__3.InterestRateLegs14__3Builder toBuilder() {
			InterestRateLegs14__3.InterestRateLegs14__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateLegs14__3.InterestRateLegs14__3Builder builder) {
			ofNullable(getFrstLeg()).ifPresent(builder::setFrstLeg);
			ofNullable(getScndLeg()).ifPresent(builder::setScndLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateLegs14__3 _that = getType().cast(o);
		
			if (!Objects.equals(frstLeg, _that.getFrstLeg())) return false;
			if (!Objects.equals(scndLeg, _that.getScndLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frstLeg != null ? frstLeg.hashCode() : 0);
			_result = 31 * _result + (scndLeg != null ? scndLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateLegs14__3 {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestRateLegs14__3  ***********************/
	class InterestRateLegs14__3BuilderImpl implements InterestRateLegs14__3.InterestRateLegs14__3Builder {
	
		protected InterestRate33Choice__3.InterestRate33Choice__3Builder frstLeg;
		protected InterestRate33Choice__1.InterestRate33Choice__1Builder scndLeg;
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstLeg")
		public InterestRate33Choice__3.InterestRate33Choice__3Builder getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		public InterestRate33Choice__3.InterestRate33Choice__3Builder getOrCreateFrstLeg() {
			InterestRate33Choice__3.InterestRate33Choice__3Builder result;
			if (frstLeg!=null) {
				result = frstLeg;
			}
			else {
				result = frstLeg = InterestRate33Choice__3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public InterestRate33Choice__1.InterestRate33Choice__1Builder getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public InterestRate33Choice__1.InterestRate33Choice__1Builder getOrCreateScndLeg() {
			InterestRate33Choice__1.InterestRate33Choice__1Builder result;
			if (scndLeg!=null) {
				result = scndLeg;
			}
			else {
				result = scndLeg = InterestRate33Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frstLeg")
		@Override
		public InterestRateLegs14__3.InterestRateLegs14__3Builder setFrstLeg(InterestRate33Choice__3 _frstLeg) {
			this.frstLeg = _frstLeg == null ? null : _frstLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scndLeg")
		@Override
		public InterestRateLegs14__3.InterestRateLegs14__3Builder setScndLeg(InterestRate33Choice__1 _scndLeg) {
			this.scndLeg = _scndLeg == null ? null : _scndLeg.toBuilder();
			return this;
		}
		
		@Override
		public InterestRateLegs14__3 build() {
			return new InterestRateLegs14__3.InterestRateLegs14__3Impl(this);
		}
		
		@Override
		public InterestRateLegs14__3.InterestRateLegs14__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateLegs14__3.InterestRateLegs14__3Builder prune() {
			if (frstLeg!=null && !frstLeg.prune().hasData()) frstLeg = null;
			if (scndLeg!=null && !scndLeg.prune().hasData()) scndLeg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFrstLeg()!=null && getFrstLeg().hasData()) return true;
			if (getScndLeg()!=null && getScndLeg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateLegs14__3.InterestRateLegs14__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestRateLegs14__3.InterestRateLegs14__3Builder o = (InterestRateLegs14__3.InterestRateLegs14__3Builder) other;
			
			merger.mergeRosetta(getFrstLeg(), o.getFrstLeg(), this::setFrstLeg);
			merger.mergeRosetta(getScndLeg(), o.getScndLeg(), this::setScndLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateLegs14__3 _that = getType().cast(o);
		
			if (!Objects.equals(frstLeg, _that.getFrstLeg())) return false;
			if (!Objects.equals(scndLeg, _that.getScndLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frstLeg != null ? frstLeg.hashCode() : 0);
			_result = 31 * _result + (scndLeg != null ? scndLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateLegs14__3Builder {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}
}
