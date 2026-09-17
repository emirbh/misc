package fpml.consolidated.doc;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.doc.meta.TradeHeaderMeta;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.IssuerTradeId;
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
 * version "recordkeeping-5.13"
 *
 * Provision A type defining trade related information which is not product specific.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining trade related information which is not product specific.
 *
 */
@RosettaDataType(value="TradeHeader", builder=TradeHeader.TradeHeaderBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeHeader", model="fpml", builder=TradeHeader.TradeHeaderBuilderImpl.class, version="2.1.1")
public interface TradeHeader extends RosettaModelObject {

	TradeHeaderMeta metaData = new TradeHeaderMeta();

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
	IssuerTradeId getUniqueSwapIdentifier();
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
	IssuerTradeId getUniqueTransactionIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trade reference identifier(s) allocated to the trade by the parties involved.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trade reference identifier(s) allocated to the trade by the parties involved.
	 *
	 */
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Additional trade information that may be provided by each involved party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Additional trade information that may be provided by each involved party.
	 *
	 */
	List<? extends PartyTradeInformation> getPartyTradeInformation();
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
	TradeSummary getTradeSummary();
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
	ProductSummary getProductSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Information about the trade package if any that the trade originated from.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information about the trade package if any that the trade originated from.
	 *
	 */
	PackageSummary getOriginatingPackage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trade date. This is the date the trade was originally executed. In the case of a novation, the novated part of the trade should be reported (by both the remaining party and the transferee) using a trade date corresponding to the date the novation was agreed. The remaining part of a trade should be reported (by both the transferor and the remaining party) using a trade date corresponding to the original execution date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trade date. This is the date the trade was originally executed. In the case of a novation, the novated part of the trade should be reported (by both the remaining party and the transferee) using a trade date corresponding to the date the novation was agreed. The remaining part of a trade should be reported (by both the transferor and the remaining party) using a trade date corresponding to the original execution date.
	 *
	 */
	IdentifiedDate getTradeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If the trade was cleared (novated) through a central counterparty clearing service, this represents the date the trade was cleared (transferred to the central counterparty).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If the trade was cleared (novated) through a central counterparty clearing service, this represents the date the trade was cleared (transferred to the central counterparty).
	 *
	 */
	IdentifiedDate getClearedDate();

	/*********************** Build Methods  ***********************/
	TradeHeader build();
	
	TradeHeader.TradeHeaderBuilder toBuilder();
	
	static TradeHeader.TradeHeaderBuilder builder() {
		return new TradeHeader.TradeHeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeHeader> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeHeader> getType() {
		return TradeHeader.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("uniqueSwapIdentifier"), processor, IssuerTradeId.class, getUniqueSwapIdentifier());
		processRosetta(path.newSubPath("uniqueTransactionIdentifier"), processor, IssuerTradeId.class, getUniqueTransactionIdentifier());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformation.class, getPartyTradeInformation());
		processRosetta(path.newSubPath("tradeSummary"), processor, TradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("productSummary"), processor, ProductSummary.class, getProductSummary());
		processRosetta(path.newSubPath("originatingPackage"), processor, PackageSummary.class, getOriginatingPackage());
		processRosetta(path.newSubPath("tradeDate"), processor, IdentifiedDate.class, getTradeDate());
		processRosetta(path.newSubPath("clearedDate"), processor, IdentifiedDate.class, getClearedDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeHeaderBuilder extends TradeHeader, RosettaModelObjectBuilder {
		IssuerTradeId.IssuerTradeIdBuilder getOrCreateUniqueSwapIdentifier();
		@Override
		IssuerTradeId.IssuerTradeIdBuilder getUniqueSwapIdentifier();
		IssuerTradeId.IssuerTradeIdBuilder getOrCreateUniqueTransactionIdentifier();
		@Override
		IssuerTradeId.IssuerTradeIdBuilder getUniqueTransactionIdentifier();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		PartyTradeInformation.PartyTradeInformationBuilder getOrCreatePartyTradeInformation(int index);
		@Override
		List<? extends PartyTradeInformation.PartyTradeInformationBuilder> getPartyTradeInformation();
		TradeSummary.TradeSummaryBuilder getOrCreateTradeSummary();
		@Override
		TradeSummary.TradeSummaryBuilder getTradeSummary();
		ProductSummary.ProductSummaryBuilder getOrCreateProductSummary();
		@Override
		ProductSummary.ProductSummaryBuilder getProductSummary();
		PackageSummary.PackageSummaryBuilder getOrCreateOriginatingPackage();
		@Override
		PackageSummary.PackageSummaryBuilder getOriginatingPackage();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateTradeDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getTradeDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateClearedDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getClearedDate();
		TradeHeader.TradeHeaderBuilder setUniqueSwapIdentifier(IssuerTradeId uniqueSwapIdentifier);
		TradeHeader.TradeHeaderBuilder setUniqueTransactionIdentifier(IssuerTradeId uniqueTransactionIdentifier);
		TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int idx);
		TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		TradeHeader.TradeHeaderBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		TradeHeader.TradeHeaderBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation);
		TradeHeader.TradeHeaderBuilder addPartyTradeInformation(PartyTradeInformation partyTradeInformation, int idx);
		TradeHeader.TradeHeaderBuilder addPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformation);
		TradeHeader.TradeHeaderBuilder setPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformation);
		TradeHeader.TradeHeaderBuilder setTradeSummary(TradeSummary tradeSummary);
		TradeHeader.TradeHeaderBuilder setProductSummary(ProductSummary productSummary);
		TradeHeader.TradeHeaderBuilder setOriginatingPackage(PackageSummary originatingPackage);
		TradeHeader.TradeHeaderBuilder setTradeDate(IdentifiedDate tradeDate);
		TradeHeader.TradeHeaderBuilder setClearedDate(IdentifiedDate clearedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("uniqueSwapIdentifier"), processor, IssuerTradeId.IssuerTradeIdBuilder.class, getUniqueSwapIdentifier());
			processRosetta(path.newSubPath("uniqueTransactionIdentifier"), processor, IssuerTradeId.IssuerTradeIdBuilder.class, getUniqueTransactionIdentifier());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("partyTradeInformation"), processor, PartyTradeInformation.PartyTradeInformationBuilder.class, getPartyTradeInformation());
			processRosetta(path.newSubPath("tradeSummary"), processor, TradeSummary.TradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("productSummary"), processor, ProductSummary.ProductSummaryBuilder.class, getProductSummary());
			processRosetta(path.newSubPath("originatingPackage"), processor, PackageSummary.PackageSummaryBuilder.class, getOriginatingPackage());
			processRosetta(path.newSubPath("tradeDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getTradeDate());
			processRosetta(path.newSubPath("clearedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getClearedDate());
		}
		

		TradeHeader.TradeHeaderBuilder prune();
	}

	/*********************** Immutable Implementation of TradeHeader  ***********************/
	class TradeHeaderImpl implements TradeHeader {
		private final IssuerTradeId uniqueSwapIdentifier;
		private final IssuerTradeId uniqueTransactionIdentifier;
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends PartyTradeInformation> partyTradeInformation;
		private final TradeSummary tradeSummary;
		private final ProductSummary productSummary;
		private final PackageSummary originatingPackage;
		private final IdentifiedDate tradeDate;
		private final IdentifiedDate clearedDate;
		
		protected TradeHeaderImpl(TradeHeader.TradeHeaderBuilder builder) {
			this.uniqueSwapIdentifier = ofNullable(builder.getUniqueSwapIdentifier()).map(f->f.build()).orElse(null);
			this.uniqueTransactionIdentifier = ofNullable(builder.getUniqueTransactionIdentifier()).map(f->f.build()).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeInformation = ofNullable(builder.getPartyTradeInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
			this.productSummary = ofNullable(builder.getProductSummary()).map(f->f.build()).orElse(null);
			this.originatingPackage = ofNullable(builder.getOriginatingPackage()).map(f->f.build()).orElse(null);
			this.tradeDate = ofNullable(builder.getTradeDate()).map(f->f.build()).orElse(null);
			this.clearedDate = ofNullable(builder.getClearedDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		public IssuerTradeId getUniqueSwapIdentifier() {
			return uniqueSwapIdentifier;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		public IssuerTradeId getUniqueTransactionIdentifier() {
			return uniqueTransactionIdentifier;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("tradeSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeSummary")
		public TradeSummary getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		@RosettaAttribute("productSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productSummary")
		public ProductSummary getProductSummary() {
			return productSummary;
		}
		
		@Override
		@RosettaAttribute("originatingPackage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingPackage")
		public PackageSummary getOriginatingPackage() {
			return originatingPackage;
		}
		
		@Override
		@RosettaAttribute("tradeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeDate")
		public IdentifiedDate getTradeDate() {
			return tradeDate;
		}
		
		@Override
		@RosettaAttribute("clearedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearedDate")
		public IdentifiedDate getClearedDate() {
			return clearedDate;
		}
		
		@Override
		public TradeHeader build() {
			return this;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder toBuilder() {
			TradeHeader.TradeHeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeHeader.TradeHeaderBuilder builder) {
			ofNullable(getUniqueSwapIdentifier()).ifPresent(builder::setUniqueSwapIdentifier);
			ofNullable(getUniqueTransactionIdentifier()).ifPresent(builder::setUniqueTransactionIdentifier);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPartyTradeInformation()).ifPresent(builder::setPartyTradeInformation);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getProductSummary()).ifPresent(builder::setProductSummary);
			ofNullable(getOriginatingPackage()).ifPresent(builder::setOriginatingPackage);
			ofNullable(getTradeDate()).ifPresent(builder::setTradeDate);
			ofNullable(getClearedDate()).ifPresent(builder::setClearedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeHeader _that = getType().cast(o);
		
			if (!Objects.equals(uniqueSwapIdentifier, _that.getUniqueSwapIdentifier())) return false;
			if (!Objects.equals(uniqueTransactionIdentifier, _that.getUniqueTransactionIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(productSummary, _that.getProductSummary())) return false;
			if (!Objects.equals(originatingPackage, _that.getOriginatingPackage())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uniqueSwapIdentifier != null ? uniqueSwapIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifier != null ? uniqueTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (productSummary != null ? productSummary.hashCode() : 0);
			_result = 31 * _result + (originatingPackage != null ? originatingPackage.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeHeader {" +
				"uniqueSwapIdentifier=" + this.uniqueSwapIdentifier + ", " +
				"uniqueTransactionIdentifier=" + this.uniqueTransactionIdentifier + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"productSummary=" + this.productSummary + ", " +
				"originatingPackage=" + this.originatingPackage + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"clearedDate=" + this.clearedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeHeader  ***********************/
	class TradeHeaderBuilderImpl implements TradeHeader.TradeHeaderBuilder {
	
		protected IssuerTradeId.IssuerTradeIdBuilder uniqueSwapIdentifier;
		protected IssuerTradeId.IssuerTradeIdBuilder uniqueTransactionIdentifier;
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<PartyTradeInformation.PartyTradeInformationBuilder> partyTradeInformation = new ArrayList<>();
		protected TradeSummary.TradeSummaryBuilder tradeSummary;
		protected ProductSummary.ProductSummaryBuilder productSummary;
		protected PackageSummary.PackageSummaryBuilder originatingPackage;
		protected IdentifiedDate.IdentifiedDateBuilder tradeDate;
		protected IdentifiedDate.IdentifiedDateBuilder clearedDate;
		
		@Override
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		public IssuerTradeId.IssuerTradeIdBuilder getUniqueSwapIdentifier() {
			return uniqueSwapIdentifier;
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder getOrCreateUniqueSwapIdentifier() {
			IssuerTradeId.IssuerTradeIdBuilder result;
			if (uniqueSwapIdentifier!=null) {
				result = uniqueSwapIdentifier;
			}
			else {
				result = uniqueSwapIdentifier = IssuerTradeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		public IssuerTradeId.IssuerTradeIdBuilder getUniqueTransactionIdentifier() {
			return uniqueTransactionIdentifier;
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder getOrCreateUniqueTransactionIdentifier() {
			IssuerTradeId.IssuerTradeIdBuilder result;
			if (uniqueTransactionIdentifier!=null) {
				result = uniqueTransactionIdentifier;
			}
			else {
				result = uniqueTransactionIdentifier = IssuerTradeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("tradeSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeSummary")
		public TradeSummary.TradeSummaryBuilder getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		public TradeSummary.TradeSummaryBuilder getOrCreateTradeSummary() {
			TradeSummary.TradeSummaryBuilder result;
			if (tradeSummary!=null) {
				result = tradeSummary;
			}
			else {
				result = tradeSummary = TradeSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productSummary")
		public ProductSummary.ProductSummaryBuilder getProductSummary() {
			return productSummary;
		}
		
		@Override
		public ProductSummary.ProductSummaryBuilder getOrCreateProductSummary() {
			ProductSummary.ProductSummaryBuilder result;
			if (productSummary!=null) {
				result = productSummary;
			}
			else {
				result = productSummary = ProductSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingPackage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingPackage")
		public PackageSummary.PackageSummaryBuilder getOriginatingPackage() {
			return originatingPackage;
		}
		
		@Override
		public PackageSummary.PackageSummaryBuilder getOrCreateOriginatingPackage() {
			PackageSummary.PackageSummaryBuilder result;
			if (originatingPackage!=null) {
				result = originatingPackage;
			}
			else {
				result = originatingPackage = PackageSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeDate")
		public IdentifiedDate.IdentifiedDateBuilder getTradeDate() {
			return tradeDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateTradeDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (tradeDate!=null) {
				result = tradeDate;
			}
			else {
				result = tradeDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clearedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearedDate")
		public IdentifiedDate.IdentifiedDateBuilder getClearedDate() {
			return clearedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateClearedDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (clearedDate!=null) {
				result = clearedDate;
			}
			else {
				result = clearedDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("uniqueSwapIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueSwapIdentifier")
		@Override
		public TradeHeader.TradeHeaderBuilder setUniqueSwapIdentifier(IssuerTradeId _uniqueSwapIdentifier) {
			this.uniqueSwapIdentifier = _uniqueSwapIdentifier == null ? null : _uniqueSwapIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("uniqueTransactionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uniqueTransactionIdentifier")
		@Override
		public TradeHeader.TradeHeaderBuilder setUniqueTransactionIdentifier(IssuerTradeId _uniqueTransactionIdentifier) {
			this.uniqueTransactionIdentifier = _uniqueTransactionIdentifier == null ? null : _uniqueTransactionIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier) {
			if (_partyTradeIdentifier != null) {
				this.partyTradeIdentifier.add(_partyTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier, int idx) {
			getIndex(this.partyTradeIdentifier, idx, () -> _partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public TradeHeader.TradeHeaderBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
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
		public TradeHeader.TradeHeaderBuilder addPartyTradeInformation(PartyTradeInformation _partyTradeInformation) {
			if (_partyTradeInformation != null) {
				this.partyTradeInformation.add(_partyTradeInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder addPartyTradeInformation(PartyTradeInformation _partyTradeInformation, int idx) {
			getIndex(this.partyTradeInformation, idx, () -> _partyTradeInformation.toBuilder());
			return this;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder addPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformations) {
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
		public TradeHeader.TradeHeaderBuilder setPartyTradeInformation(List<? extends PartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations == null) {
				this.partyTradeInformation = new ArrayList<>();
			} else {
				this.partyTradeInformation = partyTradeInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeSummary")
		@Override
		public TradeHeader.TradeHeaderBuilder setTradeSummary(TradeSummary _tradeSummary) {
			this.tradeSummary = _tradeSummary == null ? null : _tradeSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("productSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("productSummary")
		@Override
		public TradeHeader.TradeHeaderBuilder setProductSummary(ProductSummary _productSummary) {
			this.productSummary = _productSummary == null ? null : _productSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingPackage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingPackage")
		@Override
		public TradeHeader.TradeHeaderBuilder setOriginatingPackage(PackageSummary _originatingPackage) {
			this.originatingPackage = _originatingPackage == null ? null : _originatingPackage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeDate")
		@Override
		public TradeHeader.TradeHeaderBuilder setTradeDate(IdentifiedDate _tradeDate) {
			this.tradeDate = _tradeDate == null ? null : _tradeDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearedDate")
		@Override
		public TradeHeader.TradeHeaderBuilder setClearedDate(IdentifiedDate _clearedDate) {
			this.clearedDate = _clearedDate == null ? null : _clearedDate.toBuilder();
			return this;
		}
		
		@Override
		public TradeHeader build() {
			return new TradeHeader.TradeHeaderImpl(this);
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeHeader.TradeHeaderBuilder prune() {
			if (uniqueSwapIdentifier!=null && !uniqueSwapIdentifier.prune().hasData()) uniqueSwapIdentifier = null;
			if (uniqueTransactionIdentifier!=null && !uniqueTransactionIdentifier.prune().hasData()) uniqueTransactionIdentifier = null;
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyTradeInformation = partyTradeInformation.stream().filter(b->b!=null).<PartyTradeInformation.PartyTradeInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			if (productSummary!=null && !productSummary.prune().hasData()) productSummary = null;
			if (originatingPackage!=null && !originatingPackage.prune().hasData()) originatingPackage = null;
			if (tradeDate!=null && !tradeDate.prune().hasData()) tradeDate = null;
			if (clearedDate!=null && !clearedDate.prune().hasData()) clearedDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUniqueSwapIdentifier()!=null && getUniqueSwapIdentifier().hasData()) return true;
			if (getUniqueTransactionIdentifier()!=null && getUniqueTransactionIdentifier().hasData()) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeInformation()!=null && getPartyTradeInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			if (getProductSummary()!=null && getProductSummary().hasData()) return true;
			if (getOriginatingPackage()!=null && getOriginatingPackage().hasData()) return true;
			if (getTradeDate()!=null && getTradeDate().hasData()) return true;
			if (getClearedDate()!=null && getClearedDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeHeader.TradeHeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeHeader.TradeHeaderBuilder o = (TradeHeader.TradeHeaderBuilder) other;
			
			merger.mergeRosetta(getUniqueSwapIdentifier(), o.getUniqueSwapIdentifier(), this::setUniqueSwapIdentifier);
			merger.mergeRosetta(getUniqueTransactionIdentifier(), o.getUniqueTransactionIdentifier(), this::setUniqueTransactionIdentifier);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getPartyTradeInformation(), o.getPartyTradeInformation(), this::getOrCreatePartyTradeInformation);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::setTradeSummary);
			merger.mergeRosetta(getProductSummary(), o.getProductSummary(), this::setProductSummary);
			merger.mergeRosetta(getOriginatingPackage(), o.getOriginatingPackage(), this::setOriginatingPackage);
			merger.mergeRosetta(getTradeDate(), o.getTradeDate(), this::setTradeDate);
			merger.mergeRosetta(getClearedDate(), o.getClearedDate(), this::setClearedDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeHeader _that = getType().cast(o);
		
			if (!Objects.equals(uniqueSwapIdentifier, _that.getUniqueSwapIdentifier())) return false;
			if (!Objects.equals(uniqueTransactionIdentifier, _that.getUniqueTransactionIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(productSummary, _that.getProductSummary())) return false;
			if (!Objects.equals(originatingPackage, _that.getOriginatingPackage())) return false;
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(clearedDate, _that.getClearedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uniqueSwapIdentifier != null ? uniqueSwapIdentifier.hashCode() : 0);
			_result = 31 * _result + (uniqueTransactionIdentifier != null ? uniqueTransactionIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (productSummary != null ? productSummary.hashCode() : 0);
			_result = 31 * _result + (originatingPackage != null ? originatingPackage.hashCode() : 0);
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (clearedDate != null ? clearedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeHeaderBuilder {" +
				"uniqueSwapIdentifier=" + this.uniqueSwapIdentifier + ", " +
				"uniqueTransactionIdentifier=" + this.uniqueTransactionIdentifier + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"productSummary=" + this.productSummary + ", " +
				"originatingPackage=" + this.originatingPackage + ", " +
				"tradeDate=" + this.tradeDate + ", " +
				"clearedDate=" + this.clearedDate +
			'}';
		}
	}
}
