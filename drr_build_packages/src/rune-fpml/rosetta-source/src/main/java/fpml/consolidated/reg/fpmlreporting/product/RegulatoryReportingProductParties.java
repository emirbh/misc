package fpml.consolidated.reg.fpmlreporting.product;

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
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductPartiesMeta;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProductParties", builder=RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProductParties", model="fpml", builder=RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProductParties extends RosettaModelObject {

	RegulatoryReportingProductPartiesMeta metaData = new RegulatoryReportingProductPartiesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party this regulator considers to be the buyer
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party this regulator considers to be the seller.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	PartyReference getFixedPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	PartyReference getFixedReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	PartyReference getFloatingPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	PartyReference getFloatingReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	PartyReference getFloating2PayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	PartyReference getFloating2ReceiverPartyReference();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProductParties build();
	
	RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder toBuilder();
	
	static RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder builder() {
		return new RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProductParties> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProductParties> getType() {
		return RegulatoryReportingProductParties.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("fixedPayerPartyReference"), processor, PartyReference.class, getFixedPayerPartyReference());
		processRosetta(path.newSubPath("fixedReceiverPartyReference"), processor, PartyReference.class, getFixedReceiverPartyReference());
		processRosetta(path.newSubPath("floatingPayerPartyReference"), processor, PartyReference.class, getFloatingPayerPartyReference());
		processRosetta(path.newSubPath("floatingReceiverPartyReference"), processor, PartyReference.class, getFloatingReceiverPartyReference());
		processRosetta(path.newSubPath("floating2PayerPartyReference"), processor, PartyReference.class, getFloating2PayerPartyReference());
		processRosetta(path.newSubPath("floating2ReceiverPartyReference"), processor, PartyReference.class, getFloating2ReceiverPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductPartiesBuilder extends RegulatoryReportingProductParties, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateFixedPayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getFixedPayerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateFixedReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getFixedReceiverPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateFloatingPayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getFloatingPayerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateFloatingReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getFloatingReceiverPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateFloating2PayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getFloating2PayerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateFloating2ReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getFloating2ReceiverPartyReference();
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFixedPayerPartyReference(PartyReference fixedPayerPartyReference);
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFixedReceiverPartyReference(PartyReference fixedReceiverPartyReference);
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFloatingPayerPartyReference(PartyReference floatingPayerPartyReference);
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFloatingReceiverPartyReference(PartyReference floatingReceiverPartyReference);
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFloating2PayerPartyReference(PartyReference floating2PayerPartyReference);
		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFloating2ReceiverPartyReference(PartyReference floating2ReceiverPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("fixedPayerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getFixedPayerPartyReference());
			processRosetta(path.newSubPath("fixedReceiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getFixedReceiverPartyReference());
			processRosetta(path.newSubPath("floatingPayerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getFloatingPayerPartyReference());
			processRosetta(path.newSubPath("floatingReceiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getFloatingReceiverPartyReference());
			processRosetta(path.newSubPath("floating2PayerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getFloating2PayerPartyReference());
			processRosetta(path.newSubPath("floating2ReceiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getFloating2ReceiverPartyReference());
		}
		

		RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProductParties  ***********************/
	class RegulatoryReportingProductPartiesImpl implements RegulatoryReportingProductParties {
		private final PartyReference buyerPartyReference;
		private final PartyReference sellerPartyReference;
		private final PartyReference fixedPayerPartyReference;
		private final PartyReference fixedReceiverPartyReference;
		private final PartyReference floatingPayerPartyReference;
		private final PartyReference floatingReceiverPartyReference;
		private final PartyReference floating2PayerPartyReference;
		private final PartyReference floating2ReceiverPartyReference;
		
		protected RegulatoryReportingProductPartiesImpl(RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder builder) {
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.fixedPayerPartyReference = ofNullable(builder.getFixedPayerPartyReference()).map(f->f.build()).orElse(null);
			this.fixedReceiverPartyReference = ofNullable(builder.getFixedReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.floatingPayerPartyReference = ofNullable(builder.getFloatingPayerPartyReference()).map(f->f.build()).orElse(null);
			this.floatingReceiverPartyReference = ofNullable(builder.getFloatingReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.floating2PayerPartyReference = ofNullable(builder.getFloating2PayerPartyReference()).map(f->f.build()).orElse(null);
			this.floating2ReceiverPartyReference = ofNullable(builder.getFloating2ReceiverPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("fixedPayerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedPayerPartyReference")
		public PartyReference getFixedPayerPartyReference() {
			return fixedPayerPartyReference;
		}
		
		@Override
		@RosettaAttribute("fixedReceiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedReceiverPartyReference")
		public PartyReference getFixedReceiverPartyReference() {
			return fixedReceiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("floatingPayerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingPayerPartyReference")
		public PartyReference getFloatingPayerPartyReference() {
			return floatingPayerPartyReference;
		}
		
		@Override
		@RosettaAttribute("floatingReceiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingReceiverPartyReference")
		public PartyReference getFloatingReceiverPartyReference() {
			return floatingReceiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("floating2PayerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floating2PayerPartyReference")
		public PartyReference getFloating2PayerPartyReference() {
			return floating2PayerPartyReference;
		}
		
		@Override
		@RosettaAttribute("floating2ReceiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floating2ReceiverPartyReference")
		public PartyReference getFloating2ReceiverPartyReference() {
			return floating2ReceiverPartyReference;
		}
		
		@Override
		public RegulatoryReportingProductParties build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder toBuilder() {
			RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder builder) {
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getFixedPayerPartyReference()).ifPresent(builder::setFixedPayerPartyReference);
			ofNullable(getFixedReceiverPartyReference()).ifPresent(builder::setFixedReceiverPartyReference);
			ofNullable(getFloatingPayerPartyReference()).ifPresent(builder::setFloatingPayerPartyReference);
			ofNullable(getFloatingReceiverPartyReference()).ifPresent(builder::setFloatingReceiverPartyReference);
			ofNullable(getFloating2PayerPartyReference()).ifPresent(builder::setFloating2PayerPartyReference);
			ofNullable(getFloating2ReceiverPartyReference()).ifPresent(builder::setFloating2ReceiverPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductParties _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(fixedPayerPartyReference, _that.getFixedPayerPartyReference())) return false;
			if (!Objects.equals(fixedReceiverPartyReference, _that.getFixedReceiverPartyReference())) return false;
			if (!Objects.equals(floatingPayerPartyReference, _that.getFloatingPayerPartyReference())) return false;
			if (!Objects.equals(floatingReceiverPartyReference, _that.getFloatingReceiverPartyReference())) return false;
			if (!Objects.equals(floating2PayerPartyReference, _that.getFloating2PayerPartyReference())) return false;
			if (!Objects.equals(floating2ReceiverPartyReference, _that.getFloating2ReceiverPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (fixedPayerPartyReference != null ? fixedPayerPartyReference.hashCode() : 0);
			_result = 31 * _result + (fixedReceiverPartyReference != null ? fixedReceiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (floatingPayerPartyReference != null ? floatingPayerPartyReference.hashCode() : 0);
			_result = 31 * _result + (floatingReceiverPartyReference != null ? floatingReceiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (floating2PayerPartyReference != null ? floating2PayerPartyReference.hashCode() : 0);
			_result = 31 * _result + (floating2ReceiverPartyReference != null ? floating2ReceiverPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductParties {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"fixedPayerPartyReference=" + this.fixedPayerPartyReference + ", " +
				"fixedReceiverPartyReference=" + this.fixedReceiverPartyReference + ", " +
				"floatingPayerPartyReference=" + this.floatingPayerPartyReference + ", " +
				"floatingReceiverPartyReference=" + this.floatingReceiverPartyReference + ", " +
				"floating2PayerPartyReference=" + this.floating2PayerPartyReference + ", " +
				"floating2ReceiverPartyReference=" + this.floating2ReceiverPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProductParties  ***********************/
	class RegulatoryReportingProductPartiesBuilderImpl implements RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected PartyReference.PartyReferenceBuilder fixedPayerPartyReference;
		protected PartyReference.PartyReferenceBuilder fixedReceiverPartyReference;
		protected PartyReference.PartyReferenceBuilder floatingPayerPartyReference;
		protected PartyReference.PartyReferenceBuilder floatingReceiverPartyReference;
		protected PartyReference.PartyReferenceBuilder floating2PayerPartyReference;
		protected PartyReference.PartyReferenceBuilder floating2ReceiverPartyReference;
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedPayerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedPayerPartyReference")
		public PartyReference.PartyReferenceBuilder getFixedPayerPartyReference() {
			return fixedPayerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateFixedPayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (fixedPayerPartyReference!=null) {
				result = fixedPayerPartyReference;
			}
			else {
				result = fixedPayerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedReceiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedReceiverPartyReference")
		public PartyReference.PartyReferenceBuilder getFixedReceiverPartyReference() {
			return fixedReceiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateFixedReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (fixedReceiverPartyReference!=null) {
				result = fixedReceiverPartyReference;
			}
			else {
				result = fixedReceiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingPayerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingPayerPartyReference")
		public PartyReference.PartyReferenceBuilder getFloatingPayerPartyReference() {
			return floatingPayerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateFloatingPayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (floatingPayerPartyReference!=null) {
				result = floatingPayerPartyReference;
			}
			else {
				result = floatingPayerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingReceiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingReceiverPartyReference")
		public PartyReference.PartyReferenceBuilder getFloatingReceiverPartyReference() {
			return floatingReceiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateFloatingReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (floatingReceiverPartyReference!=null) {
				result = floatingReceiverPartyReference;
			}
			else {
				result = floatingReceiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floating2PayerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floating2PayerPartyReference")
		public PartyReference.PartyReferenceBuilder getFloating2PayerPartyReference() {
			return floating2PayerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateFloating2PayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (floating2PayerPartyReference!=null) {
				result = floating2PayerPartyReference;
			}
			else {
				result = floating2PayerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floating2ReceiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floating2ReceiverPartyReference")
		public PartyReference.PartyReferenceBuilder getFloating2ReceiverPartyReference() {
			return floating2ReceiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateFloating2ReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (floating2ReceiverPartyReference!=null) {
				result = floating2ReceiverPartyReference;
			}
			else {
				result = floating2ReceiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedPayerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedPayerPartyReference")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFixedPayerPartyReference(PartyReference _fixedPayerPartyReference) {
			this.fixedPayerPartyReference = _fixedPayerPartyReference == null ? null : _fixedPayerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedReceiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedReceiverPartyReference")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFixedReceiverPartyReference(PartyReference _fixedReceiverPartyReference) {
			this.fixedReceiverPartyReference = _fixedReceiverPartyReference == null ? null : _fixedReceiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingPayerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingPayerPartyReference")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFloatingPayerPartyReference(PartyReference _floatingPayerPartyReference) {
			this.floatingPayerPartyReference = _floatingPayerPartyReference == null ? null : _floatingPayerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingReceiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingReceiverPartyReference")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFloatingReceiverPartyReference(PartyReference _floatingReceiverPartyReference) {
			this.floatingReceiverPartyReference = _floatingReceiverPartyReference == null ? null : _floatingReceiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floating2PayerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floating2PayerPartyReference")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFloating2PayerPartyReference(PartyReference _floating2PayerPartyReference) {
			this.floating2PayerPartyReference = _floating2PayerPartyReference == null ? null : _floating2PayerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floating2ReceiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floating2ReceiverPartyReference")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder setFloating2ReceiverPartyReference(PartyReference _floating2ReceiverPartyReference) {
			this.floating2ReceiverPartyReference = _floating2ReceiverPartyReference == null ? null : _floating2ReceiverPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryReportingProductParties build() {
			return new RegulatoryReportingProductParties.RegulatoryReportingProductPartiesImpl(this);
		}
		
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder prune() {
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (fixedPayerPartyReference!=null && !fixedPayerPartyReference.prune().hasData()) fixedPayerPartyReference = null;
			if (fixedReceiverPartyReference!=null && !fixedReceiverPartyReference.prune().hasData()) fixedReceiverPartyReference = null;
			if (floatingPayerPartyReference!=null && !floatingPayerPartyReference.prune().hasData()) floatingPayerPartyReference = null;
			if (floatingReceiverPartyReference!=null && !floatingReceiverPartyReference.prune().hasData()) floatingReceiverPartyReference = null;
			if (floating2PayerPartyReference!=null && !floating2PayerPartyReference.prune().hasData()) floating2PayerPartyReference = null;
			if (floating2ReceiverPartyReference!=null && !floating2ReceiverPartyReference.prune().hasData()) floating2ReceiverPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getFixedPayerPartyReference()!=null && getFixedPayerPartyReference().hasData()) return true;
			if (getFixedReceiverPartyReference()!=null && getFixedReceiverPartyReference().hasData()) return true;
			if (getFloatingPayerPartyReference()!=null && getFloatingPayerPartyReference().hasData()) return true;
			if (getFloatingReceiverPartyReference()!=null && getFloatingReceiverPartyReference().hasData()) return true;
			if (getFloating2PayerPartyReference()!=null && getFloating2PayerPartyReference().hasData()) return true;
			if (getFloating2ReceiverPartyReference()!=null && getFloating2ReceiverPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder o = (RegulatoryReportingProductParties.RegulatoryReportingProductPartiesBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getFixedPayerPartyReference(), o.getFixedPayerPartyReference(), this::setFixedPayerPartyReference);
			merger.mergeRosetta(getFixedReceiverPartyReference(), o.getFixedReceiverPartyReference(), this::setFixedReceiverPartyReference);
			merger.mergeRosetta(getFloatingPayerPartyReference(), o.getFloatingPayerPartyReference(), this::setFloatingPayerPartyReference);
			merger.mergeRosetta(getFloatingReceiverPartyReference(), o.getFloatingReceiverPartyReference(), this::setFloatingReceiverPartyReference);
			merger.mergeRosetta(getFloating2PayerPartyReference(), o.getFloating2PayerPartyReference(), this::setFloating2PayerPartyReference);
			merger.mergeRosetta(getFloating2ReceiverPartyReference(), o.getFloating2ReceiverPartyReference(), this::setFloating2ReceiverPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductParties _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(fixedPayerPartyReference, _that.getFixedPayerPartyReference())) return false;
			if (!Objects.equals(fixedReceiverPartyReference, _that.getFixedReceiverPartyReference())) return false;
			if (!Objects.equals(floatingPayerPartyReference, _that.getFloatingPayerPartyReference())) return false;
			if (!Objects.equals(floatingReceiverPartyReference, _that.getFloatingReceiverPartyReference())) return false;
			if (!Objects.equals(floating2PayerPartyReference, _that.getFloating2PayerPartyReference())) return false;
			if (!Objects.equals(floating2ReceiverPartyReference, _that.getFloating2ReceiverPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (fixedPayerPartyReference != null ? fixedPayerPartyReference.hashCode() : 0);
			_result = 31 * _result + (fixedReceiverPartyReference != null ? fixedReceiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (floatingPayerPartyReference != null ? floatingPayerPartyReference.hashCode() : 0);
			_result = 31 * _result + (floatingReceiverPartyReference != null ? floatingReceiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (floating2PayerPartyReference != null ? floating2PayerPartyReference.hashCode() : 0);
			_result = 31 * _result + (floating2ReceiverPartyReference != null ? floating2ReceiverPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductPartiesBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"fixedPayerPartyReference=" + this.fixedPayerPartyReference + ", " +
				"fixedReceiverPartyReference=" + this.fixedReceiverPartyReference + ", " +
				"floatingPayerPartyReference=" + this.floatingPayerPartyReference + ", " +
				"floatingReceiverPartyReference=" + this.floatingReceiverPartyReference + ", " +
				"floating2PayerPartyReference=" + this.floating2PayerPartyReference + ", " +
				"floating2ReceiverPartyReference=" + this.floating2ReceiverPartyReference +
			'}';
		}
	}
}
