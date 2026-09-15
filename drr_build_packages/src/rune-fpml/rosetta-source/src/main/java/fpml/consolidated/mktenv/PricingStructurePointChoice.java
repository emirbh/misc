package fpml.consolidated.mktenv;

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
import fpml.consolidated.mktenv.meta.PricingStructurePointChoiceMeta;
import fpml.consolidated.riskdef.PricingDataPointCoordinate;
import fpml.consolidated.riskdef.PricingDataPointCoordinateReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

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
@RosettaDataType(value="PricingStructurePointChoice", builder=PricingStructurePointChoice.PricingStructurePointChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingStructurePointChoice", model="fpml", builder=PricingStructurePointChoice.PricingStructurePointChoiceBuilderImpl.class, version="2.1.1")
public interface PricingStructurePointChoice extends RosettaModelObject {

	PricingStructurePointChoiceMeta metaData = new PricingStructurePointChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An explicit, filled in data point coordinate. This might specify expiration, strike, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An explicit, filled in data point coordinate. This might specify expiration, strike, etc.
	 *
	 */
	PricingDataPointCoordinate getCoordinate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to a pricing data point coordinate within this document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to a pricing data point coordinate within this document.
	 *
	 */
	PricingDataPointCoordinateReference getCoordinateReference();

	/*********************** Build Methods  ***********************/
	PricingStructurePointChoice build();
	
	PricingStructurePointChoice.PricingStructurePointChoiceBuilder toBuilder();
	
	static PricingStructurePointChoice.PricingStructurePointChoiceBuilder builder() {
		return new PricingStructurePointChoice.PricingStructurePointChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingStructurePointChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingStructurePointChoice> getType() {
		return PricingStructurePointChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("coordinate"), processor, PricingDataPointCoordinate.class, getCoordinate());
		processRosetta(path.newSubPath("coordinateReference"), processor, PricingDataPointCoordinateReference.class, getCoordinateReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingStructurePointChoiceBuilder extends PricingStructurePointChoice, RosettaModelObjectBuilder {
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getOrCreateCoordinate();
		@Override
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getCoordinate();
		PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getOrCreateCoordinateReference();
		@Override
		PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getCoordinateReference();
		PricingStructurePointChoice.PricingStructurePointChoiceBuilder setCoordinate(PricingDataPointCoordinate coordinate);
		PricingStructurePointChoice.PricingStructurePointChoiceBuilder setCoordinateReference(PricingDataPointCoordinateReference coordinateReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("coordinate"), processor, PricingDataPointCoordinate.PricingDataPointCoordinateBuilder.class, getCoordinate());
			processRosetta(path.newSubPath("coordinateReference"), processor, PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder.class, getCoordinateReference());
		}
		

		PricingStructurePointChoice.PricingStructurePointChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of PricingStructurePointChoice  ***********************/
	class PricingStructurePointChoiceImpl implements PricingStructurePointChoice {
		private final PricingDataPointCoordinate coordinate;
		private final PricingDataPointCoordinateReference coordinateReference;
		
		protected PricingStructurePointChoiceImpl(PricingStructurePointChoice.PricingStructurePointChoiceBuilder builder) {
			this.coordinate = ofNullable(builder.getCoordinate()).map(f->f.build()).orElse(null);
			this.coordinateReference = ofNullable(builder.getCoordinateReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("coordinate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coordinate")
		public PricingDataPointCoordinate getCoordinate() {
			return coordinate;
		}
		
		@Override
		@RosettaAttribute("coordinateReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coordinateReference")
		public PricingDataPointCoordinateReference getCoordinateReference() {
			return coordinateReference;
		}
		
		@Override
		public PricingStructurePointChoice build() {
			return this;
		}
		
		@Override
		public PricingStructurePointChoice.PricingStructurePointChoiceBuilder toBuilder() {
			PricingStructurePointChoice.PricingStructurePointChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingStructurePointChoice.PricingStructurePointChoiceBuilder builder) {
			ofNullable(getCoordinate()).ifPresent(builder::setCoordinate);
			ofNullable(getCoordinateReference()).ifPresent(builder::setCoordinateReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructurePointChoice _that = getType().cast(o);
		
			if (!Objects.equals(coordinate, _that.getCoordinate())) return false;
			if (!Objects.equals(coordinateReference, _that.getCoordinateReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coordinate != null ? coordinate.hashCode() : 0);
			_result = 31 * _result + (coordinateReference != null ? coordinateReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructurePointChoice {" +
				"coordinate=" + this.coordinate + ", " +
				"coordinateReference=" + this.coordinateReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingStructurePointChoice  ***********************/
	class PricingStructurePointChoiceBuilderImpl implements PricingStructurePointChoice.PricingStructurePointChoiceBuilder {
	
		protected PricingDataPointCoordinate.PricingDataPointCoordinateBuilder coordinate;
		protected PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder coordinateReference;
		
		@Override
		@RosettaAttribute("coordinate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coordinate")
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getCoordinate() {
			return coordinate;
		}
		
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getOrCreateCoordinate() {
			PricingDataPointCoordinate.PricingDataPointCoordinateBuilder result;
			if (coordinate!=null) {
				result = coordinate;
			}
			else {
				result = coordinate = PricingDataPointCoordinate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coordinateReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coordinateReference")
		public PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getCoordinateReference() {
			return coordinateReference;
		}
		
		@Override
		public PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getOrCreateCoordinateReference() {
			PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder result;
			if (coordinateReference!=null) {
				result = coordinateReference;
			}
			else {
				result = coordinateReference = PricingDataPointCoordinateReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("coordinate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("coordinate")
		@Override
		public PricingStructurePointChoice.PricingStructurePointChoiceBuilder setCoordinate(PricingDataPointCoordinate _coordinate) {
			this.coordinate = _coordinate == null ? null : _coordinate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coordinateReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("coordinateReference")
		@Override
		public PricingStructurePointChoice.PricingStructurePointChoiceBuilder setCoordinateReference(PricingDataPointCoordinateReference _coordinateReference) {
			this.coordinateReference = _coordinateReference == null ? null : _coordinateReference.toBuilder();
			return this;
		}
		
		@Override
		public PricingStructurePointChoice build() {
			return new PricingStructurePointChoice.PricingStructurePointChoiceImpl(this);
		}
		
		@Override
		public PricingStructurePointChoice.PricingStructurePointChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructurePointChoice.PricingStructurePointChoiceBuilder prune() {
			if (coordinate!=null && !coordinate.prune().hasData()) coordinate = null;
			if (coordinateReference!=null && !coordinateReference.prune().hasData()) coordinateReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCoordinate()!=null && getCoordinate().hasData()) return true;
			if (getCoordinateReference()!=null && getCoordinateReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingStructurePointChoice.PricingStructurePointChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingStructurePointChoice.PricingStructurePointChoiceBuilder o = (PricingStructurePointChoice.PricingStructurePointChoiceBuilder) other;
			
			merger.mergeRosetta(getCoordinate(), o.getCoordinate(), this::setCoordinate);
			merger.mergeRosetta(getCoordinateReference(), o.getCoordinateReference(), this::setCoordinateReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingStructurePointChoice _that = getType().cast(o);
		
			if (!Objects.equals(coordinate, _that.getCoordinate())) return false;
			if (!Objects.equals(coordinateReference, _that.getCoordinateReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coordinate != null ? coordinate.hashCode() : 0);
			_result = 31 * _result + (coordinateReference != null ? coordinateReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingStructurePointChoiceBuilder {" +
				"coordinate=" + this.coordinate + ", " +
				"coordinateReference=" + this.coordinateReference +
			'}';
		}
	}
}
