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
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.riskdef.meta.PricingParameterShiftMeta;
import fpml.consolidated.shared.PricingStructureReference;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A definition of a shift with respect to a specific pricing parameter.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A definition of a shift with respect to a specific pricing parameter.
 *
 */
@RosettaDataType(value="PricingParameterShift", builder=PricingParameterShift.PricingParameterShiftBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingParameterShift", model="fpml", builder=PricingParameterShift.PricingParameterShiftBuilderImpl.class, version="2.1.1")
public interface PricingParameterShift extends RosettaModelObject {

	PricingParameterShiftMeta metaData = new PricingParameterShiftMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. A reference to the pricing input parameter to which the shift is computed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. A reference to the pricing input parameter to which the shift is computed.
	 *
	 */
	AssetOrTermPointOrPricingStructureReference getParameterReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the asset to which the shift is computed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the asset to which the shift is computed.
	 *
	 */
	AssetReference getAssetReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the term point to which the shift is computed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the term point to which the shift is computed.
	 *
	 */
	TermPointReference getTermPointReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the pricing structure to which the shift is computed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the pricing structure to which the shift is computed.
	 *
	 */
	PricingStructureReference getPricingStructureReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The size of the denominator, e.g. 0.0001 = 1 bp.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The size of the denominator, e.g. 0.0001 = 1 bp.
	 *
	 */
	BigDecimal getShift();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The units of the denominator, e.g. currency. If not present, use the units of the PricingInputReference.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The units of the denominator, e.g. currency. If not present, use the units of the PricingInputReference.
	 *
	 */
	PriceQuoteUnits getShiftUnits();

	/*********************** Build Methods  ***********************/
	PricingParameterShift build();
	
	PricingParameterShift.PricingParameterShiftBuilder toBuilder();
	
	static PricingParameterShift.PricingParameterShiftBuilder builder() {
		return new PricingParameterShift.PricingParameterShiftBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingParameterShift> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingParameterShift> getType() {
		return PricingParameterShift.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("parameterReference"), processor, AssetOrTermPointOrPricingStructureReference.class, getParameterReference());
		processRosetta(path.newSubPath("assetReference"), processor, AssetReference.class, getAssetReference());
		processRosetta(path.newSubPath("termPointReference"), processor, TermPointReference.class, getTermPointReference());
		processRosetta(path.newSubPath("pricingStructureReference"), processor, PricingStructureReference.class, getPricingStructureReference());
		processor.processBasic(path.newSubPath("shift"), BigDecimal.class, getShift(), this);
		processRosetta(path.newSubPath("shiftUnits"), processor, PriceQuoteUnits.class, getShiftUnits());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingParameterShiftBuilder extends PricingParameterShift, RosettaModelObjectBuilder {
		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getOrCreateParameterReference();
		@Override
		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getParameterReference();
		AssetReference.AssetReferenceBuilder getOrCreateAssetReference();
		@Override
		AssetReference.AssetReferenceBuilder getAssetReference();
		TermPointReference.TermPointReferenceBuilder getOrCreateTermPointReference();
		@Override
		TermPointReference.TermPointReferenceBuilder getTermPointReference();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingStructureReference();
		@Override
		PricingStructureReference.PricingStructureReferenceBuilder getPricingStructureReference();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateShiftUnits();
		@Override
		PriceQuoteUnits.PriceQuoteUnitsBuilder getShiftUnits();
		PricingParameterShift.PricingParameterShiftBuilder setId(String id);
		PricingParameterShift.PricingParameterShiftBuilder setParameterReference(AssetOrTermPointOrPricingStructureReference parameterReference);
		PricingParameterShift.PricingParameterShiftBuilder setAssetReference(AssetReference assetReference);
		PricingParameterShift.PricingParameterShiftBuilder setTermPointReference(TermPointReference termPointReference);
		PricingParameterShift.PricingParameterShiftBuilder setPricingStructureReference(PricingStructureReference pricingStructureReference);
		PricingParameterShift.PricingParameterShiftBuilder setShift(BigDecimal shift);
		PricingParameterShift.PricingParameterShiftBuilder setShiftUnits(PriceQuoteUnits shiftUnits);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("parameterReference"), processor, AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder.class, getParameterReference());
			processRosetta(path.newSubPath("assetReference"), processor, AssetReference.AssetReferenceBuilder.class, getAssetReference());
			processRosetta(path.newSubPath("termPointReference"), processor, TermPointReference.TermPointReferenceBuilder.class, getTermPointReference());
			processRosetta(path.newSubPath("pricingStructureReference"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getPricingStructureReference());
			processor.processBasic(path.newSubPath("shift"), BigDecimal.class, getShift(), this);
			processRosetta(path.newSubPath("shiftUnits"), processor, PriceQuoteUnits.PriceQuoteUnitsBuilder.class, getShiftUnits());
		}
		

		PricingParameterShift.PricingParameterShiftBuilder prune();
	}

	/*********************** Immutable Implementation of PricingParameterShift  ***********************/
	class PricingParameterShiftImpl implements PricingParameterShift {
		private final String id;
		private final AssetOrTermPointOrPricingStructureReference parameterReference;
		private final AssetReference assetReference;
		private final TermPointReference termPointReference;
		private final PricingStructureReference pricingStructureReference;
		private final BigDecimal shift;
		private final PriceQuoteUnits shiftUnits;
		
		protected PricingParameterShiftImpl(PricingParameterShift.PricingParameterShiftBuilder builder) {
			this.id = builder.getId();
			this.parameterReference = ofNullable(builder.getParameterReference()).map(f->f.build()).orElse(null);
			this.assetReference = ofNullable(builder.getAssetReference()).map(f->f.build()).orElse(null);
			this.termPointReference = ofNullable(builder.getTermPointReference()).map(f->f.build()).orElse(null);
			this.pricingStructureReference = ofNullable(builder.getPricingStructureReference()).map(f->f.build()).orElse(null);
			this.shift = builder.getShift();
			this.shiftUnits = ofNullable(builder.getShiftUnits()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("parameterReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parameterReference")
		public AssetOrTermPointOrPricingStructureReference getParameterReference() {
			return parameterReference;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetReference")
		public AssetReference getAssetReference() {
			return assetReference;
		}
		
		@Override
		@RosettaAttribute("termPointReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termPointReference")
		public TermPointReference getTermPointReference() {
			return termPointReference;
		}
		
		@Override
		@RosettaAttribute("pricingStructureReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingStructureReference")
		public PricingStructureReference getPricingStructureReference() {
			return pricingStructureReference;
		}
		
		@Override
		@RosettaAttribute("shift")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shift")
		public BigDecimal getShift() {
			return shift;
		}
		
		@Override
		@RosettaAttribute("shiftUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shiftUnits")
		public PriceQuoteUnits getShiftUnits() {
			return shiftUnits;
		}
		
		@Override
		public PricingParameterShift build() {
			return this;
		}
		
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder toBuilder() {
			PricingParameterShift.PricingParameterShiftBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingParameterShift.PricingParameterShiftBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getParameterReference()).ifPresent(builder::setParameterReference);
			ofNullable(getAssetReference()).ifPresent(builder::setAssetReference);
			ofNullable(getTermPointReference()).ifPresent(builder::setTermPointReference);
			ofNullable(getPricingStructureReference()).ifPresent(builder::setPricingStructureReference);
			ofNullable(getShift()).ifPresent(builder::setShift);
			ofNullable(getShiftUnits()).ifPresent(builder::setShiftUnits);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingParameterShift _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(parameterReference, _that.getParameterReference())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(termPointReference, _that.getTermPointReference())) return false;
			if (!Objects.equals(pricingStructureReference, _that.getPricingStructureReference())) return false;
			if (!Objects.equals(shift, _that.getShift())) return false;
			if (!Objects.equals(shiftUnits, _that.getShiftUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (parameterReference != null ? parameterReference.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (termPointReference != null ? termPointReference.hashCode() : 0);
			_result = 31 * _result + (pricingStructureReference != null ? pricingStructureReference.hashCode() : 0);
			_result = 31 * _result + (shift != null ? shift.hashCode() : 0);
			_result = 31 * _result + (shiftUnits != null ? shiftUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingParameterShift {" +
				"id=" + this.id + ", " +
				"parameterReference=" + this.parameterReference + ", " +
				"assetReference=" + this.assetReference + ", " +
				"termPointReference=" + this.termPointReference + ", " +
				"pricingStructureReference=" + this.pricingStructureReference + ", " +
				"shift=" + this.shift + ", " +
				"shiftUnits=" + this.shiftUnits +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingParameterShift  ***********************/
	class PricingParameterShiftBuilderImpl implements PricingParameterShift.PricingParameterShiftBuilder {
	
		protected String id;
		protected AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder parameterReference;
		protected AssetReference.AssetReferenceBuilder assetReference;
		protected TermPointReference.TermPointReferenceBuilder termPointReference;
		protected PricingStructureReference.PricingStructureReferenceBuilder pricingStructureReference;
		protected BigDecimal shift;
		protected PriceQuoteUnits.PriceQuoteUnitsBuilder shiftUnits;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("parameterReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parameterReference")
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getParameterReference() {
			return parameterReference;
		}
		
		@Override
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getOrCreateParameterReference() {
			AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder result;
			if (parameterReference!=null) {
				result = parameterReference;
			}
			else {
				result = parameterReference = AssetOrTermPointOrPricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetReference")
		public AssetReference.AssetReferenceBuilder getAssetReference() {
			return assetReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateAssetReference() {
			AssetReference.AssetReferenceBuilder result;
			if (assetReference!=null) {
				result = assetReference;
			}
			else {
				result = assetReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("termPointReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termPointReference")
		public TermPointReference.TermPointReferenceBuilder getTermPointReference() {
			return termPointReference;
		}
		
		@Override
		public TermPointReference.TermPointReferenceBuilder getOrCreateTermPointReference() {
			TermPointReference.TermPointReferenceBuilder result;
			if (termPointReference!=null) {
				result = termPointReference;
			}
			else {
				result = termPointReference = TermPointReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingStructureReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingStructureReference")
		public PricingStructureReference.PricingStructureReferenceBuilder getPricingStructureReference() {
			return pricingStructureReference;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingStructureReference() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (pricingStructureReference!=null) {
				result = pricingStructureReference;
			}
			else {
				result = pricingStructureReference = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("shift")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shift")
		public BigDecimal getShift() {
			return shift;
		}
		
		@Override
		@RosettaAttribute("shiftUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shiftUnits")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getShiftUnits() {
			return shiftUnits;
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateShiftUnits() {
			PriceQuoteUnits.PriceQuoteUnitsBuilder result;
			if (shiftUnits!=null) {
				result = shiftUnits;
			}
			else {
				result = shiftUnits = PriceQuoteUnits.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("parameterReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parameterReference")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder setParameterReference(AssetOrTermPointOrPricingStructureReference _parameterReference) {
			this.parameterReference = _parameterReference == null ? null : _parameterReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetReference")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder setAssetReference(AssetReference _assetReference) {
			this.assetReference = _assetReference == null ? null : _assetReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termPointReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termPointReference")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder setTermPointReference(TermPointReference _termPointReference) {
			this.termPointReference = _termPointReference == null ? null : _termPointReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingStructureReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingStructureReference")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder setPricingStructureReference(PricingStructureReference _pricingStructureReference) {
			this.pricingStructureReference = _pricingStructureReference == null ? null : _pricingStructureReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("shift")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shift")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder setShift(BigDecimal _shift) {
			this.shift = _shift == null ? null : _shift;
			return this;
		}
		
		@RosettaAttribute("shiftUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shiftUnits")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder setShiftUnits(PriceQuoteUnits _shiftUnits) {
			this.shiftUnits = _shiftUnits == null ? null : _shiftUnits.toBuilder();
			return this;
		}
		
		@Override
		public PricingParameterShift build() {
			return new PricingParameterShift.PricingParameterShiftImpl(this);
		}
		
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder prune() {
			if (parameterReference!=null && !parameterReference.prune().hasData()) parameterReference = null;
			if (assetReference!=null && !assetReference.prune().hasData()) assetReference = null;
			if (termPointReference!=null && !termPointReference.prune().hasData()) termPointReference = null;
			if (pricingStructureReference!=null && !pricingStructureReference.prune().hasData()) pricingStructureReference = null;
			if (shiftUnits!=null && !shiftUnits.prune().hasData()) shiftUnits = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getParameterReference()!=null && getParameterReference().hasData()) return true;
			if (getAssetReference()!=null && getAssetReference().hasData()) return true;
			if (getTermPointReference()!=null && getTermPointReference().hasData()) return true;
			if (getPricingStructureReference()!=null && getPricingStructureReference().hasData()) return true;
			if (getShift()!=null) return true;
			if (getShiftUnits()!=null && getShiftUnits().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingParameterShift.PricingParameterShiftBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingParameterShift.PricingParameterShiftBuilder o = (PricingParameterShift.PricingParameterShiftBuilder) other;
			
			merger.mergeRosetta(getParameterReference(), o.getParameterReference(), this::setParameterReference);
			merger.mergeRosetta(getAssetReference(), o.getAssetReference(), this::setAssetReference);
			merger.mergeRosetta(getTermPointReference(), o.getTermPointReference(), this::setTermPointReference);
			merger.mergeRosetta(getPricingStructureReference(), o.getPricingStructureReference(), this::setPricingStructureReference);
			merger.mergeRosetta(getShiftUnits(), o.getShiftUnits(), this::setShiftUnits);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getShift(), o.getShift(), this::setShift);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingParameterShift _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(parameterReference, _that.getParameterReference())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(termPointReference, _that.getTermPointReference())) return false;
			if (!Objects.equals(pricingStructureReference, _that.getPricingStructureReference())) return false;
			if (!Objects.equals(shift, _that.getShift())) return false;
			if (!Objects.equals(shiftUnits, _that.getShiftUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (parameterReference != null ? parameterReference.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (termPointReference != null ? termPointReference.hashCode() : 0);
			_result = 31 * _result + (pricingStructureReference != null ? pricingStructureReference.hashCode() : 0);
			_result = 31 * _result + (shift != null ? shift.hashCode() : 0);
			_result = 31 * _result + (shiftUnits != null ? shiftUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingParameterShiftBuilder {" +
				"id=" + this.id + ", " +
				"parameterReference=" + this.parameterReference + ", " +
				"assetReference=" + this.assetReference + ", " +
				"termPointReference=" + this.termPointReference + ", " +
				"pricingStructureReference=" + this.pricingStructureReference + ", " +
				"shift=" + this.shift + ", " +
				"shiftUnits=" + this.shiftUnits +
			'}';
		}
	}
}
