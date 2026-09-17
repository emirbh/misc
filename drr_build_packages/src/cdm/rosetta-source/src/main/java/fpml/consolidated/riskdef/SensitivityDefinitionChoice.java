package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.SensitivityDefinitionChoiceMeta;
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
@RosettaDataType(value="SensitivityDefinitionChoice", builder=SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SensitivityDefinitionChoice", model="fpml", builder=SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilderImpl.class, version="2.1.1")
public interface SensitivityDefinitionChoice extends RosettaModelObject {

	SensitivityDefinitionChoiceMeta metaData = new SensitivityDefinitionChoiceMeta();

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
	SensitivityDefinitionChoice build();
	
	SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder toBuilder();
	
	static SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder builder() {
		return new SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivityDefinitionChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SensitivityDefinitionChoice> getType() {
		return SensitivityDefinitionChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("coordinate"), processor, PricingDataPointCoordinate.class, getCoordinate());
		processRosetta(path.newSubPath("coordinateReference"), processor, PricingDataPointCoordinateReference.class, getCoordinateReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivityDefinitionChoiceBuilder extends SensitivityDefinitionChoice, RosettaModelObjectBuilder {
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getOrCreateCoordinate();
		@Override
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder getCoordinate();
		PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getOrCreateCoordinateReference();
		@Override
		PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder getCoordinateReference();
		SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder setCoordinate(PricingDataPointCoordinate coordinate);
		SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder setCoordinateReference(PricingDataPointCoordinateReference coordinateReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("coordinate"), processor, PricingDataPointCoordinate.PricingDataPointCoordinateBuilder.class, getCoordinate());
			processRosetta(path.newSubPath("coordinateReference"), processor, PricingDataPointCoordinateReference.PricingDataPointCoordinateReferenceBuilder.class, getCoordinateReference());
		}
		

		SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivityDefinitionChoice  ***********************/
	class SensitivityDefinitionChoiceImpl implements SensitivityDefinitionChoice {
		private final PricingDataPointCoordinate coordinate;
		private final PricingDataPointCoordinateReference coordinateReference;
		
		protected SensitivityDefinitionChoiceImpl(SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder builder) {
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
		public SensitivityDefinitionChoice build() {
			return this;
		}
		
		@Override
		public SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder toBuilder() {
			SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder builder) {
			ofNullable(getCoordinate()).ifPresent(builder::setCoordinate);
			ofNullable(getCoordinateReference()).ifPresent(builder::setCoordinateReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityDefinitionChoice _that = getType().cast(o);
		
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
			return "SensitivityDefinitionChoice {" +
				"coordinate=" + this.coordinate + ", " +
				"coordinateReference=" + this.coordinateReference +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivityDefinitionChoice  ***********************/
	class SensitivityDefinitionChoiceBuilderImpl implements SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder {
	
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
		public SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder setCoordinate(PricingDataPointCoordinate _coordinate) {
			this.coordinate = _coordinate == null ? null : _coordinate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coordinateReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("coordinateReference")
		@Override
		public SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder setCoordinateReference(PricingDataPointCoordinateReference _coordinateReference) {
			this.coordinateReference = _coordinateReference == null ? null : _coordinateReference.toBuilder();
			return this;
		}
		
		@Override
		public SensitivityDefinitionChoice build() {
			return new SensitivityDefinitionChoice.SensitivityDefinitionChoiceImpl(this);
		}
		
		@Override
		public SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder prune() {
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
		public SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder o = (SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder) other;
			
			merger.mergeRosetta(getCoordinate(), o.getCoordinate(), this::setCoordinate);
			merger.mergeRosetta(getCoordinateReference(), o.getCoordinateReference(), this::setCoordinateReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityDefinitionChoice _that = getType().cast(o);
		
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
			return "SensitivityDefinitionChoiceBuilder {" +
				"coordinate=" + this.coordinate + ", " +
				"coordinateReference=" + this.coordinateReference +
			'}';
		}
	}
}
