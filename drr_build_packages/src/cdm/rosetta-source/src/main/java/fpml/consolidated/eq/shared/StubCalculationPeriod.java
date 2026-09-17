package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.StubCalculationPeriodMeta;
import fpml.consolidated.shared.Stub;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the Stub Calculation Period.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the Stub Calculation Period.
 *
 */
@RosettaDataType(value="StubCalculationPeriod", builder=StubCalculationPeriod.StubCalculationPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="StubCalculationPeriod", model="fpml", builder=StubCalculationPeriod.StubCalculationPeriodBuilderImpl.class, version="2.1.1")
public interface StubCalculationPeriod extends RosettaModelObject {

	StubCalculationPeriodMeta metaData = new StubCalculationPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Stub getInitialStub();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Stub getFinalStub();

	/*********************** Build Methods  ***********************/
	StubCalculationPeriod build();
	
	StubCalculationPeriod.StubCalculationPeriodBuilder toBuilder();
	
	static StubCalculationPeriod.StubCalculationPeriodBuilder builder() {
		return new StubCalculationPeriod.StubCalculationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StubCalculationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StubCalculationPeriod> getType() {
		return StubCalculationPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initialStub"), processor, Stub.class, getInitialStub());
		processRosetta(path.newSubPath("finalStub"), processor, Stub.class, getFinalStub());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StubCalculationPeriodBuilder extends StubCalculationPeriod, RosettaModelObjectBuilder {
		Stub.StubBuilder getOrCreateInitialStub();
		@Override
		Stub.StubBuilder getInitialStub();
		Stub.StubBuilder getOrCreateFinalStub();
		@Override
		Stub.StubBuilder getFinalStub();
		StubCalculationPeriod.StubCalculationPeriodBuilder setInitialStub(Stub initialStub);
		StubCalculationPeriod.StubCalculationPeriodBuilder setFinalStub(Stub finalStub);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initialStub"), processor, Stub.StubBuilder.class, getInitialStub());
			processRosetta(path.newSubPath("finalStub"), processor, Stub.StubBuilder.class, getFinalStub());
		}
		

		StubCalculationPeriod.StubCalculationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of StubCalculationPeriod  ***********************/
	class StubCalculationPeriodImpl implements StubCalculationPeriod {
		private final Stub initialStub;
		private final Stub finalStub;
		
		protected StubCalculationPeriodImpl(StubCalculationPeriod.StubCalculationPeriodBuilder builder) {
			this.initialStub = ofNullable(builder.getInitialStub()).map(f->f.build()).orElse(null);
			this.finalStub = ofNullable(builder.getFinalStub()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialStub")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialStub")
		public Stub getInitialStub() {
			return initialStub;
		}
		
		@Override
		@RosettaAttribute("finalStub")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalStub")
		public Stub getFinalStub() {
			return finalStub;
		}
		
		@Override
		public StubCalculationPeriod build() {
			return this;
		}
		
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder toBuilder() {
			StubCalculationPeriod.StubCalculationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StubCalculationPeriod.StubCalculationPeriodBuilder builder) {
			ofNullable(getInitialStub()).ifPresent(builder::setInitialStub);
			ofNullable(getFinalStub()).ifPresent(builder::setFinalStub);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(initialStub, _that.getInitialStub())) return false;
			if (!Objects.equals(finalStub, _that.getFinalStub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialStub != null ? initialStub.hashCode() : 0);
			_result = 31 * _result + (finalStub != null ? finalStub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubCalculationPeriod {" +
				"initialStub=" + this.initialStub + ", " +
				"finalStub=" + this.finalStub +
			'}';
		}
	}

	/*********************** Builder Implementation of StubCalculationPeriod  ***********************/
	class StubCalculationPeriodBuilderImpl implements StubCalculationPeriod.StubCalculationPeriodBuilder {
	
		protected Stub.StubBuilder initialStub;
		protected Stub.StubBuilder finalStub;
		
		@Override
		@RosettaAttribute("initialStub")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialStub")
		public Stub.StubBuilder getInitialStub() {
			return initialStub;
		}
		
		@Override
		public Stub.StubBuilder getOrCreateInitialStub() {
			Stub.StubBuilder result;
			if (initialStub!=null) {
				result = initialStub;
			}
			else {
				result = initialStub = Stub.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalStub")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalStub")
		public Stub.StubBuilder getFinalStub() {
			return finalStub;
		}
		
		@Override
		public Stub.StubBuilder getOrCreateFinalStub() {
			Stub.StubBuilder result;
			if (finalStub!=null) {
				result = finalStub;
			}
			else {
				result = finalStub = Stub.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("initialStub")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialStub")
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder setInitialStub(Stub _initialStub) {
			this.initialStub = _initialStub == null ? null : _initialStub.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalStub")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalStub")
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder setFinalStub(Stub _finalStub) {
			this.finalStub = _finalStub == null ? null : _finalStub.toBuilder();
			return this;
		}
		
		@Override
		public StubCalculationPeriod build() {
			return new StubCalculationPeriod.StubCalculationPeriodImpl(this);
		}
		
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder prune() {
			if (initialStub!=null && !initialStub.prune().hasData()) initialStub = null;
			if (finalStub!=null && !finalStub.prune().hasData()) finalStub = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialStub()!=null && getInitialStub().hasData()) return true;
			if (getFinalStub()!=null && getFinalStub().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StubCalculationPeriod.StubCalculationPeriodBuilder o = (StubCalculationPeriod.StubCalculationPeriodBuilder) other;
			
			merger.mergeRosetta(getInitialStub(), o.getInitialStub(), this::setInitialStub);
			merger.mergeRosetta(getFinalStub(), o.getFinalStub(), this::setFinalStub);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(initialStub, _that.getInitialStub())) return false;
			if (!Objects.equals(finalStub, _that.getFinalStub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialStub != null ? initialStub.hashCode() : 0);
			_result = 31 * _result + (finalStub != null ? finalStub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubCalculationPeriodBuilder {" +
				"initialStub=" + this.initialStub + ", " +
				"finalStub=" + this.finalStub +
			'}';
		}
	}
}
