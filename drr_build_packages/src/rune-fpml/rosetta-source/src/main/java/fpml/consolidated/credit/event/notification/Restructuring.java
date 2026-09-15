package fpml.consolidated.credit.event.notification;

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
import fpml.consolidated.credit.event.notification.meta.RestructuringMeta;
import fpml.consolidated.shared.Money;


/**
 * @version 2.1.1
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
@RosettaDataType(value="Restructuring", builder=Restructuring.RestructuringBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Restructuring", model="fpml", builder=Restructuring.RestructuringBuilderImpl.class, version="2.1.1")
public interface Restructuring extends RestructuringEvent {

	RestructuringMeta metaData = new RestructuringMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Restructuring build();
	
	Restructuring.RestructuringBuilder toBuilder();
	
	static Restructuring.RestructuringBuilder builder() {
		return new Restructuring.RestructuringBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Restructuring> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Restructuring> getType() {
		return Restructuring.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partialExerciseAmount"), processor, Money.class, getPartialExerciseAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RestructuringBuilder extends Restructuring, RestructuringEvent.RestructuringEventBuilder {
		@Override
		Restructuring.RestructuringBuilder setPartialExerciseAmount(Money partialExerciseAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partialExerciseAmount"), processor, Money.MoneyBuilder.class, getPartialExerciseAmount());
		}
		

		Restructuring.RestructuringBuilder prune();
	}

	/*********************** Immutable Implementation of Restructuring  ***********************/
	class RestructuringImpl extends RestructuringEvent.RestructuringEventImpl implements Restructuring {
		
		protected RestructuringImpl(Restructuring.RestructuringBuilder builder) {
			super(builder);
		}
		
		@Override
		public Restructuring build() {
			return this;
		}
		
		@Override
		public Restructuring.RestructuringBuilder toBuilder() {
			Restructuring.RestructuringBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Restructuring.RestructuringBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Restructuring {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Restructuring  ***********************/
	class RestructuringBuilderImpl extends RestructuringEvent.RestructuringEventBuilderImpl implements Restructuring.RestructuringBuilder {
	
		
		@RosettaAttribute("partialExerciseAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partialExerciseAmount")
		@Override
		public Restructuring.RestructuringBuilder setPartialExerciseAmount(Money _partialExerciseAmount) {
			this.partialExerciseAmount = _partialExerciseAmount == null ? null : _partialExerciseAmount.toBuilder();
			return this;
		}
		
		@Override
		public Restructuring build() {
			return new Restructuring.RestructuringImpl(this);
		}
		
		@Override
		public Restructuring.RestructuringBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Restructuring.RestructuringBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Restructuring.RestructuringBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Restructuring.RestructuringBuilder o = (Restructuring.RestructuringBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RestructuringBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
