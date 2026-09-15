package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.meta.TradeReferenceInformationMeta;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines a type that allows trade identifiers and/or trade information to be represented for a trade.
 *
 */
@RosettaDataType(value="TradeReferenceInformation", builder=TradeReferenceInformation.TradeReferenceInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeReferenceInformation", model="fpml", builder=TradeReferenceInformation.TradeReferenceInformationBuilderImpl.class, version="2.1.1")
public interface TradeReferenceInformation extends RosettaModelObject {

	TradeReferenceInformationMeta metaData = new TradeReferenceInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to describe why a trade was created. This can be used to provide context for a newly created trade that is not part of a post-trade event. For example, it can report that the trade was created as a result of netting activity, or due to a transfer, an allocation process, etc. Omitting this implies that the trade record was created as a result of a negotiated new trade.
	 *
	 */
	OriginatingEvent getOriginatingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to describe why a trade was terminated.
	 *
	 */
	TerminatingEvent getTerminatingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This allows the acknowledging party to supply additional trade identifiers for a trade underlying a request relating to a business event.
	 *
	 */
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This allows the acknowledging party to supply additional trade information about a trade underlying a request relating to a business event.
	 *
	 */
	List<? extends PartyTradeInformation> getPartyTradeInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	ProductType getProductType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	ProductId getProductId();

	/*********************** Build Methods  ***********************/
	TradeReferenceInformation build();
	
	TradeReferenceInformation.TradeReferenceInformationBuilder toBuilder();
	
	static TradeReferenceInformation.TradeReferenceInformationBuilder builder() {
		return new TradeReferenceInformation.TradeReferenceInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReferenceInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeReferenceInformation> getType() {
		return TradeReferenceInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.class, getTerminatingEvent());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformation.class, getPartyTradeInformation());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeReferenceInformationBuilder extends TradeReferenceInformation, RosettaModelObjectBuilder {
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		@Override
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent();
		@Override
		TerminatingEvent.TerminatingEventBuilder getTerminatingEvent();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		PartyTradeInformation.PartyTradeInformationBuilder getOrCreatePartyTradeInformation(int index);
		@Override
		List<? extends PartyTradeInformation.PartyTradeInformationBuilder> getPartyTradeInformation();
		ProductType.ProductTypeBuilder getOrCreateProductType();
		@Override
		ProductType.ProductTypeBuilder getProductType();
		ProductId.ProductIdBuilder getOrCreateProductId();
		@Override
		ProductId.ProductIdBuilder getProductId();
		TradeReferenceInformation.TradeReferenceInformationBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		TradeReferenceInformation.TradeReferenceInformationBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int idx);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		TradeReferenceInformation.TradeReferenceInformationBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation, int idx);
		TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformation);
		TradeReferenceInformation.TradeReferenceInformationBuilder setPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformation);
		TradeReferenceInformation.TradeReferenceInformationBuilder setProductType(ProductType productType);
		TradeReferenceInformation.TradeReferenceInformationBuilder setProductId(ProductId productId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.TerminatingEventBuilder.class, getTerminatingEvent());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformation.PartyTradeInformationBuilder.class, getPartyTradeInformation());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
		}
		

		TradeReferenceInformation.TradeReferenceInformationBuilder prune();
	}

	/*********************** Immutable Implementation of TradeReferenceInformation  ***********************/
	class TradeReferenceInformationImpl implements TradeReferenceInformation {
		private final OriginatingEvent originatingEvent;
		private final TerminatingEvent terminatingEvent;
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends PartyTradeInformation> partyTradeInformation;
		private final ProductType productType;
		private final ProductId productId;
		
		protected TradeReferenceInformationImpl(TradeReferenceInformation.TradeReferenceInformationBuilder builder) {
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.terminatingEvent = ofNullable(builder.getTerminatingEvent()).map(f->f.build()).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeInformation = ofNullable(builder.getPartyTradeInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productType = ofNullable(builder.getProductType()).map(f->f.build()).orElse(null);
			this.productId = ofNullable(builder.getProductId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminatingEvent")
		public TerminatingEvent getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		public List<? extends PartyTradeInformation> getPartyTradeInformation() {
			return partyTradeInformation;
		}
		
		@Override
		@RosettaAttribute("productType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productType")
		public ProductType getProductType() {
			return productType;
		}
		
		@Override
		@RosettaAttribute("productId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productId")
		public ProductId getProductId() {
			return productId;
		}
		
		@Override
		public TradeReferenceInformation build() {
			return this;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder toBuilder() {
			TradeReferenceInformation.TradeReferenceInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReferenceInformation.TradeReferenceInformationBuilder builder) {
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTerminatingEvent()).ifPresent(builder::setTerminatingEvent);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPartyTradeInformation()).ifPresent(builder::setPartyTradeInformation);
			ofNullable(getProductType()).ifPresent(builder::setProductType);
			ofNullable(getProductId()).ifPresent(builder::setProductId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(productId, _that.getProductId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReferenceInformation {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeReferenceInformation  ***********************/
	class TradeReferenceInformationBuilderImpl implements TradeReferenceInformation.TradeReferenceInformationBuilder {
	
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected TerminatingEvent.TerminatingEventBuilder terminatingEvent;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<PartyTradeInformation.PartyTradeInformationBuilder> partyTradeInformation = new ArrayList<>();
		protected ProductType.ProductTypeBuilder productType;
		protected ProductId.ProductIdBuilder productId;
		
		@Override
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent.OriginatingEventBuilder getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent() {
			OriginatingEvent.OriginatingEventBuilder result;
			if (originatingEvent!=null) {
				result = originatingEvent;
			}
			else {
				result = originatingEvent = OriginatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminatingEvent")
		public TerminatingEvent.TerminatingEventBuilder getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		public TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent() {
			TerminatingEvent.TerminatingEventBuilder result;
			if (terminatingEvent!=null) {
				result = terminatingEvent;
			}
			else {
				result = terminatingEvent = TerminatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index) {
			if (partyTradeIdentifier==null) {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			return getIndex(partyTradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newPartyTradeIdentifier = PartyTradeIdentifier.builder();
						return newPartyTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		public List<? extends PartyTradeInformation.PartyTradeInformationBuilder> getPartyTradeInformation() {
			return partyTradeInformation;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder getOrCreatePartyTradeInformation(int index) {
			if (partyTradeInformation==null) {
				this.partyTradeInformation = new ArrayList<>();
			}
			return getIndex(partyTradeInformation, index, () -> {
						PartyTradeInformation.PartyTradeInformationBuilder newPartyTradeInformation = PartyTradeInformation.builder();
						return newPartyTradeInformation;
					});
		}
		
		@Override
		@RosettaAttribute("productType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productType")
		public ProductType.ProductTypeBuilder getProductType() {
			return productType;
		}
		
		@Override
		public ProductType.ProductTypeBuilder getOrCreateProductType() {
			ProductType.ProductTypeBuilder result;
			if (productType!=null) {
				result = productType;
			}
			else {
				result = productType = ProductType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productId")
		public ProductId.ProductIdBuilder getProductId() {
			return productId;
		}
		
		@Override
		public ProductId.ProductIdBuilder getOrCreateProductId() {
			ProductId.ProductIdBuilder result;
			if (productId!=null) {
				result = productId;
			}
			else {
				result = productId = ProductId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminatingEvent")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder setTerminatingEvent(TerminatingEvent _terminatingEvent) {
			this.terminatingEvent = _terminatingEvent == null ? null : _terminatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier) {
			if (_partyTradeIdentifier != null) {
				this.partyTradeIdentifier.add(_partyTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier, int idx) {
			getIndex(this.partyTradeIdentifier, idx, () -> _partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers == null) {
				this.partyTradeIdentifier = new ArrayList<>();
			} else {
				this.partyTradeIdentifier = partyTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(PartyTradeInformation _partyTradeInformation) {
			if (_partyTradeInformation != null) {
				this.partyTradeInformation.add(_partyTradeInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(PartyTradeInformation _partyTradeInformation, int idx) {
			getIndex(this.partyTradeInformation, idx, () -> _partyTradeInformation.toBuilder());
			return this;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder addPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations != null) {
				for (final PartyTradeInformation toAdd : partyTradeInformations) {
					this.partyTradeInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder setPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations == null) {
				this.partyTradeInformation = new ArrayList<>();
			} else {
				this.partyTradeInformation = partyTradeInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("productType")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder setProductType(ProductType _productType) {
			this.productType = _productType == null ? null : _productType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("productId")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder setProductId(ProductId _productId) {
			this.productId = _productId == null ? null : _productId.toBuilder();
			return this;
		}
		
		@Override
		public TradeReferenceInformation build() {
			return new TradeReferenceInformation.TradeReferenceInformationImpl(this);
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder prune() {
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			if (terminatingEvent!=null && !terminatingEvent.prune().hasData()) terminatingEvent = null;
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyTradeInformation = partyTradeInformation.stream().filter(b->b!=null).<PartyTradeInformation.PartyTradeInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (productType!=null && !productType.prune().hasData()) productType = null;
			if (productId!=null && !productId.prune().hasData()) productId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTerminatingEvent()!=null && getTerminatingEvent().hasData()) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeInformation()!=null && getPartyTradeInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductType()!=null && getProductType().hasData()) return true;
			if (getProductId()!=null && getProductId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeReferenceInformation.TradeReferenceInformationBuilder o = (TradeReferenceInformation.TradeReferenceInformationBuilder) other;
			
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTerminatingEvent(), o.getTerminatingEvent(), this::setTerminatingEvent);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getPartyTradeInformation(), o.getPartyTradeInformation(), this::getOrCreatePartyTradeInformation);
			merger.mergeRosetta(getProductType(), o.getProductType(), this::setProductType);
			merger.mergeRosetta(getProductId(), o.getProductId(), this::setProductId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReferenceInformation _that = getType().cast(o);
		
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(productId, _that.getProductId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (productType != null ? productType.hashCode() : 0);
			_result = 31 * _result + (productId != null ? productId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReferenceInformationBuilder {" +
				"originatingEvent=" + this.originatingEvent + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"productType=" + this.productType + ", " +
				"productId=" + this.productId +
			'}';
		}
	}
}
