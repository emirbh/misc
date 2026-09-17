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
import fpml.consolidated.doc.meta.PartyTradeIdentifierMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
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
 * Provision A type defining one or more trade identifiers allocated to the trade by a party. A link identifier allows the trade to be associated with other related trades, e.g. trades forming part of a larger structured transaction. It is expected that for external communication of trade there will be only one tradeId sent in the document per party.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining one or more trade identifiers allocated to the trade by a party. A link identifier allows the trade to be associated with other related trades, e.g. trades forming part of a larger structured transaction. It is expected that for external communication of trade there will be only one tradeId sent in the document per party.
 *
 */
@RosettaDataType(value="PartyTradeIdentifier", builder=PartyTradeIdentifier.PartyTradeIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyTradeIdentifier", model="fpml", builder=PartyTradeIdentifier.PartyTradeIdentifierBuilderImpl.class, version="2.1.1")
public interface PartyTradeIdentifier extends TradeIdentifier {

	PartyTradeIdentifierMeta metaData = new PartyTradeIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A link identifier allowing the trade to be associated with other related trades, e.g. the linkId may contain a tradeId for an associated trade or several related trades may be given the same linkId. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list. For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A link identifier allowing the trade to be associated with other related trades, e.g. the linkId may contain a tradeId for an associated trade or several related trades may be given the same linkId. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list. For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 */
	List<? extends LinkId> getLinkId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trade id of the allocated trade. This is used by the block trade to reference the allocated trade. For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trade id of the allocated trade. This is used by the block trade to reference the allocated trade. For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 */
	List<? extends TradeIdentifier> getAllocationTradeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trade id of a resulting trade (beta or gamma trade) that resulted from this trade during a clearing or similar operation (e.g. prime brokerage). For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trade id of a resulting trade (beta or gamma trade) that resulted from this trade during a clearing or similar operation (e.g. prime brokerage). For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 */
	List<? extends TradeIdentifierExtended> getResultingTradeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trade id of the block trade. This is used by each one of the allocated trades to reference the block trade. This element can also represent the trade id of the parent trade for N-level allocations. In the case, this element is only used to model N-level allocations in which the trade acts as block and allocated trade at the same time. This basically means the ability to allocate a block trade to multiple allocation trades, and then allocate these in turn to other allocation trades (and so on if desired). For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trade id of the block trade. This is used by each one of the allocated trades to reference the block trade. This element can also represent the trade id of the parent trade for N-level allocations. In the case, this element is only used to model N-level allocations in which the trade acts as block and allocated trade at the same time. This basically means the ability to allocate a block trade to multiple allocation trades, and then allocate these in turn to other allocation trades (and so on if desired). For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 */
	TradeIdentifier getBlockTradeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The trade id of the trade(s) upon which this was based, for example the ID of the trade that was submitted for clearing if this is a cleared trade, or of the original trade if this was novated or cancelled and rebooked, or the list of trades that were netted or compressed together in the case of a compression event. The originatingEvent will explain why the trade was created; the existence and number of originatingTradeId elements should correspond to the originatingEvent, and they should be interpreted using that field. If the trade is inside a business event structure (such as a novation or a compression event) this element shuld not be populated; instead the event shoudl be used to represent the other trades. For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trade id of the trade(s) upon which this was based, for example the ID of the trade that was submitted for clearing if this is a cleared trade, or of the original trade if this was novated or cancelled and rebooked, or the list of trades that were netted or compressed together in the case of a compression event. The originatingEvent will explain why the trade was created; the existence and number of originatingTradeId elements should correspond to the originatingEvent, and they should be interpreted using that field. If the trade is inside a business event structure (such as a novation or a compression event) this element shuld not be populated; instead the event shoudl be used to represent the other trades. For new implementations, the use of the "linkedTrade" element is preferred.
	 *
	 */
	List<? extends TradeIdentifier> getOriginatingTradeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Deprecated: The USIs of the components of this trade, when this trade contains a strategy.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Deprecated: The USIs of the components of this trade, when this trade contains a strategy.
	 *
	 */
	List<? extends ProductComponentIdentifier> getProductComponentIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Related trades
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Related trades
	 *
	 */
	List<? extends LinkedTrade> getLinkedTrade();

	/*********************** Build Methods  ***********************/
	PartyTradeIdentifier build();
	
	PartyTradeIdentifier.PartyTradeIdentifierBuilder toBuilder();
	
	static PartyTradeIdentifier.PartyTradeIdentifierBuilder builder() {
		return new PartyTradeIdentifier.PartyTradeIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyTradeIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyTradeIdentifier> getType() {
		return PartyTradeIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.class, getTradeIdentifierChoice());
		processRosetta(path.newSubPath("linkId"), processor, LinkId.class, getLinkId());
		processRosetta(path.newSubPath("allocationTradeId"), processor, TradeIdentifier.class, getAllocationTradeId());
		processRosetta(path.newSubPath("resultingTradeId"), processor, TradeIdentifierExtended.class, getResultingTradeId());
		processRosetta(path.newSubPath("blockTradeId"), processor, TradeIdentifier.class, getBlockTradeId());
		processRosetta(path.newSubPath("originatingTradeId"), processor, TradeIdentifier.class, getOriginatingTradeId());
		processRosetta(path.newSubPath("productComponentIdentifier"), processor, ProductComponentIdentifier.class, getProductComponentIdentifier());
		processRosetta(path.newSubPath("linkedTrade"), processor, LinkedTrade.class, getLinkedTrade());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyTradeIdentifierBuilder extends PartyTradeIdentifier, TradeIdentifier.TradeIdentifierBuilder {
		LinkId.LinkIdBuilder getOrCreateLinkId(int index);
		@Override
		List<? extends LinkId.LinkIdBuilder> getLinkId();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateAllocationTradeId(int index);
		@Override
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getAllocationTradeId();
		TradeIdentifierExtended.TradeIdentifierExtendedBuilder getOrCreateResultingTradeId(int index);
		@Override
		List<? extends TradeIdentifierExtended.TradeIdentifierExtendedBuilder> getResultingTradeId();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeId();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getBlockTradeId();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateOriginatingTradeId(int index);
		@Override
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getOriginatingTradeId();
		ProductComponentIdentifier.ProductComponentIdentifierBuilder getOrCreateProductComponentIdentifier(int index);
		@Override
		List<? extends ProductComponentIdentifier.ProductComponentIdentifierBuilder> getProductComponentIdentifier();
		LinkedTrade.LinkedTradeBuilder getOrCreateLinkedTrade(int index);
		@Override
		List<? extends LinkedTrade.LinkedTradeBuilder> getLinkedTrade();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setId(String id);
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setIssuer(IssuerId issuer);
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setTradeId(TradeId tradeId);
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setPartyReference(PartyReference partyReference);
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setAccountReference(AccountReference accountReference);
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice);
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice, int idx);
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(LinkId linkId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(LinkId linkId, int idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(List<? extends LinkId> linkId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setLinkId(List<? extends LinkId> linkId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(TradeIdentifier allocationTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(TradeIdentifier allocationTradeId, int idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(List<? extends TradeIdentifier> allocationTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setAllocationTradeId(List<? extends TradeIdentifier> allocationTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(TradeIdentifierExtended resultingTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(TradeIdentifierExtended resultingTradeId, int idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(List<? extends TradeIdentifierExtended> resultingTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setResultingTradeId(List<? extends TradeIdentifierExtended> resultingTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setBlockTradeId(TradeIdentifier blockTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(TradeIdentifier originatingTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(TradeIdentifier originatingTradeId, int idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(List<? extends TradeIdentifier> originatingTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setOriginatingTradeId(List<? extends TradeIdentifier> originatingTradeId);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(ProductComponentIdentifier productComponentIdentifier);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(ProductComponentIdentifier productComponentIdentifier, int idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(List<? extends ProductComponentIdentifier> productComponentIdentifier);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setProductComponentIdentifier(List<? extends ProductComponentIdentifier> productComponentIdentifier);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkedTrade(LinkedTrade linkedTrade);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkedTrade(LinkedTrade linkedTrade, int idx);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkedTrade(List<? extends LinkedTrade> linkedTrade);
		PartyTradeIdentifier.PartyTradeIdentifierBuilder setLinkedTrade(List<? extends LinkedTrade> linkedTrade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.TradeIdentifierChoiceBuilder.class, getTradeIdentifierChoice());
			processRosetta(path.newSubPath("linkId"), processor, LinkId.LinkIdBuilder.class, getLinkId());
			processRosetta(path.newSubPath("allocationTradeId"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getAllocationTradeId());
			processRosetta(path.newSubPath("resultingTradeId"), processor, TradeIdentifierExtended.TradeIdentifierExtendedBuilder.class, getResultingTradeId());
			processRosetta(path.newSubPath("blockTradeId"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getBlockTradeId());
			processRosetta(path.newSubPath("originatingTradeId"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getOriginatingTradeId());
			processRosetta(path.newSubPath("productComponentIdentifier"), processor, ProductComponentIdentifier.ProductComponentIdentifierBuilder.class, getProductComponentIdentifier());
			processRosetta(path.newSubPath("linkedTrade"), processor, LinkedTrade.LinkedTradeBuilder.class, getLinkedTrade());
		}
		

		PartyTradeIdentifier.PartyTradeIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of PartyTradeIdentifier  ***********************/
	class PartyTradeIdentifierImpl extends TradeIdentifier.TradeIdentifierImpl implements PartyTradeIdentifier {
		private final List<? extends LinkId> linkId;
		private final List<? extends TradeIdentifier> allocationTradeId;
		private final List<? extends TradeIdentifierExtended> resultingTradeId;
		private final TradeIdentifier blockTradeId;
		private final List<? extends TradeIdentifier> originatingTradeId;
		private final List<? extends ProductComponentIdentifier> productComponentIdentifier;
		private final List<? extends LinkedTrade> linkedTrade;
		
		protected PartyTradeIdentifierImpl(PartyTradeIdentifier.PartyTradeIdentifierBuilder builder) {
			super(builder);
			this.linkId = ofNullable(builder.getLinkId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.allocationTradeId = ofNullable(builder.getAllocationTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.resultingTradeId = ofNullable(builder.getResultingTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.blockTradeId = ofNullable(builder.getBlockTradeId()).map(f->f.build()).orElse(null);
			this.originatingTradeId = ofNullable(builder.getOriginatingTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.productComponentIdentifier = ofNullable(builder.getProductComponentIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.linkedTrade = ofNullable(builder.getLinkedTrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("linkId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("linkId")
		public List<? extends LinkId> getLinkId() {
			return linkId;
		}
		
		@Override
		@RosettaAttribute("allocationTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("allocationTradeId")
		public List<? extends TradeIdentifier> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		@Override
		@RosettaAttribute("resultingTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("resultingTradeId")
		public List<? extends TradeIdentifierExtended> getResultingTradeId() {
			return resultingTradeId;
		}
		
		@Override
		@RosettaAttribute("blockTradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("blockTradeId")
		public TradeIdentifier getBlockTradeId() {
			return blockTradeId;
		}
		
		@Override
		@RosettaAttribute("originatingTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("originatingTradeId")
		public List<? extends TradeIdentifier> getOriginatingTradeId() {
			return originatingTradeId;
		}
		
		@Override
		@RosettaAttribute("productComponentIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productComponentIdentifier")
		public List<? extends ProductComponentIdentifier> getProductComponentIdentifier() {
			return productComponentIdentifier;
		}
		
		@Override
		@RosettaAttribute("linkedTrade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("linkedTrade")
		public List<? extends LinkedTrade> getLinkedTrade() {
			return linkedTrade;
		}
		
		@Override
		public PartyTradeIdentifier build() {
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder toBuilder() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTradeIdentifier.PartyTradeIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLinkId()).ifPresent(builder::setLinkId);
			ofNullable(getAllocationTradeId()).ifPresent(builder::setAllocationTradeId);
			ofNullable(getResultingTradeId()).ifPresent(builder::setResultingTradeId);
			ofNullable(getBlockTradeId()).ifPresent(builder::setBlockTradeId);
			ofNullable(getOriginatingTradeId()).ifPresent(builder::setOriginatingTradeId);
			ofNullable(getProductComponentIdentifier()).ifPresent(builder::setProductComponentIdentifier);
			ofNullable(getLinkedTrade()).ifPresent(builder::setLinkedTrade);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyTradeIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(linkId, _that.getLinkId())) return false;
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!ListEquals.listEquals(resultingTradeId, _that.getResultingTradeId())) return false;
			if (!Objects.equals(blockTradeId, _that.getBlockTradeId())) return false;
			if (!ListEquals.listEquals(originatingTradeId, _that.getOriginatingTradeId())) return false;
			if (!ListEquals.listEquals(productComponentIdentifier, _that.getProductComponentIdentifier())) return false;
			if (!ListEquals.listEquals(linkedTrade, _that.getLinkedTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (linkId != null ? linkId.hashCode() : 0);
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (resultingTradeId != null ? resultingTradeId.hashCode() : 0);
			_result = 31 * _result + (blockTradeId != null ? blockTradeId.hashCode() : 0);
			_result = 31 * _result + (originatingTradeId != null ? originatingTradeId.hashCode() : 0);
			_result = 31 * _result + (productComponentIdentifier != null ? productComponentIdentifier.hashCode() : 0);
			_result = 31 * _result + (linkedTrade != null ? linkedTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeIdentifier {" +
				"linkId=" + this.linkId + ", " +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"resultingTradeId=" + this.resultingTradeId + ", " +
				"blockTradeId=" + this.blockTradeId + ", " +
				"originatingTradeId=" + this.originatingTradeId + ", " +
				"productComponentIdentifier=" + this.productComponentIdentifier + ", " +
				"linkedTrade=" + this.linkedTrade +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PartyTradeIdentifier  ***********************/
	class PartyTradeIdentifierBuilderImpl extends TradeIdentifier.TradeIdentifierBuilderImpl implements PartyTradeIdentifier.PartyTradeIdentifierBuilder {
	
		protected List<LinkId.LinkIdBuilder> linkId = new ArrayList<>();
		protected List<TradeIdentifier.TradeIdentifierBuilder> allocationTradeId = new ArrayList<>();
		protected List<TradeIdentifierExtended.TradeIdentifierExtendedBuilder> resultingTradeId = new ArrayList<>();
		protected TradeIdentifier.TradeIdentifierBuilder blockTradeId;
		protected List<TradeIdentifier.TradeIdentifierBuilder> originatingTradeId = new ArrayList<>();
		protected List<ProductComponentIdentifier.ProductComponentIdentifierBuilder> productComponentIdentifier = new ArrayList<>();
		protected List<LinkedTrade.LinkedTradeBuilder> linkedTrade = new ArrayList<>();
		
		@Override
		@RosettaAttribute("linkId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("linkId")
		public List<? extends LinkId.LinkIdBuilder> getLinkId() {
			return linkId;
		}
		
		@Override
		public LinkId.LinkIdBuilder getOrCreateLinkId(int index) {
			if (linkId==null) {
				this.linkId = new ArrayList<>();
			}
			return getIndex(linkId, index, () -> {
						LinkId.LinkIdBuilder newLinkId = LinkId.builder();
						return newLinkId;
					});
		}
		
		@Override
		@RosettaAttribute("allocationTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("allocationTradeId")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateAllocationTradeId(int index) {
			if (allocationTradeId==null) {
				this.allocationTradeId = new ArrayList<>();
			}
			return getIndex(allocationTradeId, index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newAllocationTradeId = TradeIdentifier.builder();
						return newAllocationTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("resultingTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("resultingTradeId")
		public List<? extends TradeIdentifierExtended.TradeIdentifierExtendedBuilder> getResultingTradeId() {
			return resultingTradeId;
		}
		
		@Override
		public TradeIdentifierExtended.TradeIdentifierExtendedBuilder getOrCreateResultingTradeId(int index) {
			if (resultingTradeId==null) {
				this.resultingTradeId = new ArrayList<>();
			}
			return getIndex(resultingTradeId, index, () -> {
						TradeIdentifierExtended.TradeIdentifierExtendedBuilder newResultingTradeId = TradeIdentifierExtended.builder();
						return newResultingTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("blockTradeId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("blockTradeId")
		public TradeIdentifier.TradeIdentifierBuilder getBlockTradeId() {
			return blockTradeId;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeId() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (blockTradeId!=null) {
				result = blockTradeId;
			}
			else {
				result = blockTradeId = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("originatingTradeId")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getOriginatingTradeId() {
			return originatingTradeId;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateOriginatingTradeId(int index) {
			if (originatingTradeId==null) {
				this.originatingTradeId = new ArrayList<>();
			}
			return getIndex(originatingTradeId, index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newOriginatingTradeId = TradeIdentifier.builder();
						return newOriginatingTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("productComponentIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productComponentIdentifier")
		public List<? extends ProductComponentIdentifier.ProductComponentIdentifierBuilder> getProductComponentIdentifier() {
			return productComponentIdentifier;
		}
		
		@Override
		public ProductComponentIdentifier.ProductComponentIdentifierBuilder getOrCreateProductComponentIdentifier(int index) {
			if (productComponentIdentifier==null) {
				this.productComponentIdentifier = new ArrayList<>();
			}
			return getIndex(productComponentIdentifier, index, () -> {
						ProductComponentIdentifier.ProductComponentIdentifierBuilder newProductComponentIdentifier = ProductComponentIdentifier.builder();
						return newProductComponentIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("linkedTrade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("linkedTrade")
		public List<? extends LinkedTrade.LinkedTradeBuilder> getLinkedTrade() {
			return linkedTrade;
		}
		
		@Override
		public LinkedTrade.LinkedTradeBuilder getOrCreateLinkedTrade(int index) {
			if (linkedTrade==null) {
				this.linkedTrade = new ArrayList<>();
			}
			return getIndex(linkedTrade, index, () -> {
						LinkedTrade.LinkedTradeBuilder newLinkedTrade = LinkedTrade.builder();
						return newLinkedTrade;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuer")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setIssuer(IssuerId _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice) {
			if (_tradeIdentifierChoice != null) {
				this.tradeIdentifierChoice.add(_tradeIdentifierChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice, int idx) {
			getIndex(this.tradeIdentifierChoice, idx, () -> _tradeIdentifierChoice.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices != null) {
				for (final TradeIdentifierChoice toAdd : tradeIdentifierChoices) {
					this.tradeIdentifierChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices == null) {
				this.tradeIdentifierChoice = new ArrayList<>();
			} else {
				this.tradeIdentifierChoice = tradeIdentifierChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("linkId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("linkId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(LinkId _linkId) {
			if (_linkId != null) {
				this.linkId.add(_linkId.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(LinkId _linkId, int idx) {
			getIndex(this.linkId, idx, () -> _linkId.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkId(List<? extends LinkId> linkIds) {
			if (linkIds != null) {
				for (final LinkId toAdd : linkIds) {
					this.linkId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("linkId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("linkId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setLinkId(List<? extends LinkId> linkIds) {
			if (linkIds == null) {
				this.linkId = new ArrayList<>();
			} else {
				this.linkId = linkIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("allocationTradeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("allocationTradeId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(TradeIdentifier _allocationTradeId) {
			if (_allocationTradeId != null) {
				this.allocationTradeId.add(_allocationTradeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(TradeIdentifier _allocationTradeId, int idx) {
			getIndex(this.allocationTradeId, idx, () -> _allocationTradeId.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addAllocationTradeId(List<? extends TradeIdentifier> allocationTradeIds) {
			if (allocationTradeIds != null) {
				for (final TradeIdentifier toAdd : allocationTradeIds) {
					this.allocationTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("allocationTradeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("allocationTradeId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setAllocationTradeId(List<? extends TradeIdentifier> allocationTradeIds) {
			if (allocationTradeIds == null) {
				this.allocationTradeId = new ArrayList<>();
			} else {
				this.allocationTradeId = allocationTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("resultingTradeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("resultingTradeId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(TradeIdentifierExtended _resultingTradeId) {
			if (_resultingTradeId != null) {
				this.resultingTradeId.add(_resultingTradeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(TradeIdentifierExtended _resultingTradeId, int idx) {
			getIndex(this.resultingTradeId, idx, () -> _resultingTradeId.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addResultingTradeId(List<? extends TradeIdentifierExtended> resultingTradeIds) {
			if (resultingTradeIds != null) {
				for (final TradeIdentifierExtended toAdd : resultingTradeIds) {
					this.resultingTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("resultingTradeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("resultingTradeId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setResultingTradeId(List<? extends TradeIdentifierExtended> resultingTradeIds) {
			if (resultingTradeIds == null) {
				this.resultingTradeId = new ArrayList<>();
			} else {
				this.resultingTradeId = resultingTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("blockTradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("blockTradeId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setBlockTradeId(TradeIdentifier _blockTradeId) {
			this.blockTradeId = _blockTradeId == null ? null : _blockTradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingTradeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("originatingTradeId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(TradeIdentifier _originatingTradeId) {
			if (_originatingTradeId != null) {
				this.originatingTradeId.add(_originatingTradeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(TradeIdentifier _originatingTradeId, int idx) {
			getIndex(this.originatingTradeId, idx, () -> _originatingTradeId.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addOriginatingTradeId(List<? extends TradeIdentifier> originatingTradeIds) {
			if (originatingTradeIds != null) {
				for (final TradeIdentifier toAdd : originatingTradeIds) {
					this.originatingTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("originatingTradeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("originatingTradeId")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setOriginatingTradeId(List<? extends TradeIdentifier> originatingTradeIds) {
			if (originatingTradeIds == null) {
				this.originatingTradeId = new ArrayList<>();
			} else {
				this.originatingTradeId = originatingTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productComponentIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productComponentIdentifier")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(ProductComponentIdentifier _productComponentIdentifier) {
			if (_productComponentIdentifier != null) {
				this.productComponentIdentifier.add(_productComponentIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(ProductComponentIdentifier _productComponentIdentifier, int idx) {
			getIndex(this.productComponentIdentifier, idx, () -> _productComponentIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addProductComponentIdentifier(List<? extends ProductComponentIdentifier> productComponentIdentifiers) {
			if (productComponentIdentifiers != null) {
				for (final ProductComponentIdentifier toAdd : productComponentIdentifiers) {
					this.productComponentIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productComponentIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productComponentIdentifier")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setProductComponentIdentifier(List<? extends ProductComponentIdentifier> productComponentIdentifiers) {
			if (productComponentIdentifiers == null) {
				this.productComponentIdentifier = new ArrayList<>();
			} else {
				this.productComponentIdentifier = productComponentIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("linkedTrade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("linkedTrade")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkedTrade(LinkedTrade _linkedTrade) {
			if (_linkedTrade != null) {
				this.linkedTrade.add(_linkedTrade.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkedTrade(LinkedTrade _linkedTrade, int idx) {
			getIndex(this.linkedTrade, idx, () -> _linkedTrade.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder addLinkedTrade(List<? extends LinkedTrade> linkedTrades) {
			if (linkedTrades != null) {
				for (final LinkedTrade toAdd : linkedTrades) {
					this.linkedTrade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("linkedTrade")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("linkedTrade")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder setLinkedTrade(List<? extends LinkedTrade> linkedTrades) {
			if (linkedTrades == null) {
				this.linkedTrade = new ArrayList<>();
			} else {
				this.linkedTrade = linkedTrades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyTradeIdentifier build() {
			return new PartyTradeIdentifier.PartyTradeIdentifierImpl(this);
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder prune() {
			super.prune();
			linkId = linkId.stream().filter(b->b!=null).<LinkId.LinkIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			allocationTradeId = allocationTradeId.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			resultingTradeId = resultingTradeId.stream().filter(b->b!=null).<TradeIdentifierExtended.TradeIdentifierExtendedBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (blockTradeId!=null && !blockTradeId.prune().hasData()) blockTradeId = null;
			originatingTradeId = originatingTradeId.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			productComponentIdentifier = productComponentIdentifier.stream().filter(b->b!=null).<ProductComponentIdentifier.ProductComponentIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			linkedTrade = linkedTrade.stream().filter(b->b!=null).<LinkedTrade.LinkedTradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLinkId()!=null && getLinkId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAllocationTradeId()!=null && getAllocationTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getResultingTradeId()!=null && getResultingTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBlockTradeId()!=null && getBlockTradeId().hasData()) return true;
			if (getOriginatingTradeId()!=null && getOriginatingTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProductComponentIdentifier()!=null && getProductComponentIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLinkedTrade()!=null && getLinkedTrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PartyTradeIdentifier.PartyTradeIdentifierBuilder o = (PartyTradeIdentifier.PartyTradeIdentifierBuilder) other;
			
			merger.mergeRosetta(getLinkId(), o.getLinkId(), this::getOrCreateLinkId);
			merger.mergeRosetta(getAllocationTradeId(), o.getAllocationTradeId(), this::getOrCreateAllocationTradeId);
			merger.mergeRosetta(getResultingTradeId(), o.getResultingTradeId(), this::getOrCreateResultingTradeId);
			merger.mergeRosetta(getBlockTradeId(), o.getBlockTradeId(), this::setBlockTradeId);
			merger.mergeRosetta(getOriginatingTradeId(), o.getOriginatingTradeId(), this::getOrCreateOriginatingTradeId);
			merger.mergeRosetta(getProductComponentIdentifier(), o.getProductComponentIdentifier(), this::getOrCreateProductComponentIdentifier);
			merger.mergeRosetta(getLinkedTrade(), o.getLinkedTrade(), this::getOrCreateLinkedTrade);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyTradeIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(linkId, _that.getLinkId())) return false;
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!ListEquals.listEquals(resultingTradeId, _that.getResultingTradeId())) return false;
			if (!Objects.equals(blockTradeId, _that.getBlockTradeId())) return false;
			if (!ListEquals.listEquals(originatingTradeId, _that.getOriginatingTradeId())) return false;
			if (!ListEquals.listEquals(productComponentIdentifier, _that.getProductComponentIdentifier())) return false;
			if (!ListEquals.listEquals(linkedTrade, _that.getLinkedTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (linkId != null ? linkId.hashCode() : 0);
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (resultingTradeId != null ? resultingTradeId.hashCode() : 0);
			_result = 31 * _result + (blockTradeId != null ? blockTradeId.hashCode() : 0);
			_result = 31 * _result + (originatingTradeId != null ? originatingTradeId.hashCode() : 0);
			_result = 31 * _result + (productComponentIdentifier != null ? productComponentIdentifier.hashCode() : 0);
			_result = 31 * _result + (linkedTrade != null ? linkedTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeIdentifierBuilder {" +
				"linkId=" + this.linkId + ", " +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"resultingTradeId=" + this.resultingTradeId + ", " +
				"blockTradeId=" + this.blockTradeId + ", " +
				"originatingTradeId=" + this.originatingTradeId + ", " +
				"productComponentIdentifier=" + this.productComponentIdentifier + ", " +
				"linkedTrade=" + this.linkedTrade +
			'}' + " " + super.toString();
		}
	}
}
