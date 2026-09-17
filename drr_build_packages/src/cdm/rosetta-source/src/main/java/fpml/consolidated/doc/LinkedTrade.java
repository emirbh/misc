package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.LinkedTradeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for representing information about a trade related to this. It identifies the related trade and the type of relationship.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for representing information about a trade related to this. It identifies the related trade and the type of relationship.
 *
 */
@RosettaDataType(value="LinkedTrade", builder=LinkedTrade.LinkedTradeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LinkedTrade", model="fpml", builder=LinkedTrade.LinkedTradeBuilderImpl.class, version="2.1.1")
public interface LinkedTrade extends RosettaModelObject {

	LinkedTradeMeta metaData = new LinkedTradeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type or reason for a linked trade. For example, it may be the block trade that originated this allocation trade, or a beta or gamma trade that resulted from this trade submitted for clearing.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type or reason for a linked trade. For example, it may be the block trade that originated this allocation trade, or a beta or gamma trade that resulted from this trade submitted for clearing.
	 *
	 */
	LinkType getLinkType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The identifier of the linked trade. In the case the linked trade is identified by a USI or UTI, the issuer prefix and transaction ID components should be concatenated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The identifier of the linked trade. In the case the linked trade is identified by a USI or UTI, the issuer prefix and transaction ID components should be concatenated.
	 *
	 */
	LinkId getLinkId();

	/*********************** Build Methods  ***********************/
	LinkedTrade build();
	
	LinkedTrade.LinkedTradeBuilder toBuilder();
	
	static LinkedTrade.LinkedTradeBuilder builder() {
		return new LinkedTrade.LinkedTradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LinkedTrade> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LinkedTrade> getType() {
		return LinkedTrade.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("linkType"), processor, LinkType.class, getLinkType());
		processRosetta(path.newSubPath("linkId"), processor, LinkId.class, getLinkId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LinkedTradeBuilder extends LinkedTrade, RosettaModelObjectBuilder {
		LinkType.LinkTypeBuilder getOrCreateLinkType();
		@Override
		LinkType.LinkTypeBuilder getLinkType();
		LinkId.LinkIdBuilder getOrCreateLinkId();
		@Override
		LinkId.LinkIdBuilder getLinkId();
		LinkedTrade.LinkedTradeBuilder setLinkType(LinkType linkType);
		LinkedTrade.LinkedTradeBuilder setLinkId(LinkId linkId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("linkType"), processor, LinkType.LinkTypeBuilder.class, getLinkType());
			processRosetta(path.newSubPath("linkId"), processor, LinkId.LinkIdBuilder.class, getLinkId());
		}
		

		LinkedTrade.LinkedTradeBuilder prune();
	}

	/*********************** Immutable Implementation of LinkedTrade  ***********************/
	class LinkedTradeImpl implements LinkedTrade {
		private final LinkType linkType;
		private final LinkId linkId;
		
		protected LinkedTradeImpl(LinkedTrade.LinkedTradeBuilder builder) {
			this.linkType = ofNullable(builder.getLinkType()).map(f->f.build()).orElse(null);
			this.linkId = ofNullable(builder.getLinkId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("linkType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("linkType")
		public LinkType getLinkType() {
			return linkType;
		}
		
		@Override
		@RosettaAttribute("linkId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("linkId")
		public LinkId getLinkId() {
			return linkId;
		}
		
		@Override
		public LinkedTrade build() {
			return this;
		}
		
		@Override
		public LinkedTrade.LinkedTradeBuilder toBuilder() {
			LinkedTrade.LinkedTradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LinkedTrade.LinkedTradeBuilder builder) {
			ofNullable(getLinkType()).ifPresent(builder::setLinkType);
			ofNullable(getLinkId()).ifPresent(builder::setLinkId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LinkedTrade _that = getType().cast(o);
		
			if (!Objects.equals(linkType, _that.getLinkType())) return false;
			if (!Objects.equals(linkId, _that.getLinkId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (linkType != null ? linkType.hashCode() : 0);
			_result = 31 * _result + (linkId != null ? linkId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LinkedTrade {" +
				"linkType=" + this.linkType + ", " +
				"linkId=" + this.linkId +
			'}';
		}
	}

	/*********************** Builder Implementation of LinkedTrade  ***********************/
	class LinkedTradeBuilderImpl implements LinkedTrade.LinkedTradeBuilder {
	
		protected LinkType.LinkTypeBuilder linkType;
		protected LinkId.LinkIdBuilder linkId;
		
		@Override
		@RosettaAttribute("linkType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("linkType")
		public LinkType.LinkTypeBuilder getLinkType() {
			return linkType;
		}
		
		@Override
		public LinkType.LinkTypeBuilder getOrCreateLinkType() {
			LinkType.LinkTypeBuilder result;
			if (linkType!=null) {
				result = linkType;
			}
			else {
				result = linkType = LinkType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("linkId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("linkId")
		public LinkId.LinkIdBuilder getLinkId() {
			return linkId;
		}
		
		@Override
		public LinkId.LinkIdBuilder getOrCreateLinkId() {
			LinkId.LinkIdBuilder result;
			if (linkId!=null) {
				result = linkId;
			}
			else {
				result = linkId = LinkId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("linkType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("linkType")
		@Override
		public LinkedTrade.LinkedTradeBuilder setLinkType(LinkType _linkType) {
			this.linkType = _linkType == null ? null : _linkType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("linkId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("linkId")
		@Override
		public LinkedTrade.LinkedTradeBuilder setLinkId(LinkId _linkId) {
			this.linkId = _linkId == null ? null : _linkId.toBuilder();
			return this;
		}
		
		@Override
		public LinkedTrade build() {
			return new LinkedTrade.LinkedTradeImpl(this);
		}
		
		@Override
		public LinkedTrade.LinkedTradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LinkedTrade.LinkedTradeBuilder prune() {
			if (linkType!=null && !linkType.prune().hasData()) linkType = null;
			if (linkId!=null && !linkId.prune().hasData()) linkId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLinkType()!=null && getLinkType().hasData()) return true;
			if (getLinkId()!=null && getLinkId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LinkedTrade.LinkedTradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LinkedTrade.LinkedTradeBuilder o = (LinkedTrade.LinkedTradeBuilder) other;
			
			merger.mergeRosetta(getLinkType(), o.getLinkType(), this::setLinkType);
			merger.mergeRosetta(getLinkId(), o.getLinkId(), this::setLinkId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LinkedTrade _that = getType().cast(o);
		
			if (!Objects.equals(linkType, _that.getLinkType())) return false;
			if (!Objects.equals(linkId, _that.getLinkId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (linkType != null ? linkType.hashCode() : 0);
			_result = 31 * _result + (linkId != null ? linkId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LinkedTradeBuilder {" +
				"linkType=" + this.linkType + ", " +
				"linkId=" + this.linkId +
			'}';
		}
	}
}
