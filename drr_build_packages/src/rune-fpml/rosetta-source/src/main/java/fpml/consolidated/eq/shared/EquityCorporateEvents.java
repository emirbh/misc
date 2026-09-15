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
import fpml.consolidated.eq.shared.meta.EquityCorporateEventsMeta;
import fpml.consolidated.fpmlenum.ShareExtraordinaryEventEnum;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining the merger events and their treatment.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining the merger events and their treatment.
 *
 */
@RosettaDataType(value="EquityCorporateEvents", builder=EquityCorporateEvents.EquityCorporateEventsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityCorporateEvents", model="fpml", builder=EquityCorporateEvents.EquityCorporateEventsBuilderImpl.class, version="2.1.1")
public interface EquityCorporateEvents extends RosettaModelObject {

	EquityCorporateEventsMeta metaData = new EquityCorporateEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The consideration paid for the original shares following the Merger Event consists wholly of new shares.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The consideration paid for the original shares following the Merger Event consists wholly of new shares.
	 *
	 */
	ShareExtraordinaryEventEnum getShareForShare();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The consideration paid for the original shares following the Merger Event consists wholly of cash/securities other than new shares.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The consideration paid for the original shares following the Merger Event consists wholly of cash/securities other than new shares.
	 *
	 */
	ShareExtraordinaryEventEnum getShareForOther();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The consideration paid for the original shares following the Merger Event consists of both cash/securities and new shares.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The consideration paid for the original shares following the Merger Event consists of both cash/securities and new shares.
	 *
	 */
	ShareExtraordinaryEventEnum getShareForCombined();

	/*********************** Build Methods  ***********************/
	EquityCorporateEvents build();
	
	EquityCorporateEvents.EquityCorporateEventsBuilder toBuilder();
	
	static EquityCorporateEvents.EquityCorporateEventsBuilder builder() {
		return new EquityCorporateEvents.EquityCorporateEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityCorporateEvents> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityCorporateEvents> getType() {
		return EquityCorporateEvents.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("shareForShare"), ShareExtraordinaryEventEnum.class, getShareForShare(), this);
		processor.processBasic(path.newSubPath("shareForOther"), ShareExtraordinaryEventEnum.class, getShareForOther(), this);
		processor.processBasic(path.newSubPath("shareForCombined"), ShareExtraordinaryEventEnum.class, getShareForCombined(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityCorporateEventsBuilder extends EquityCorporateEvents, RosettaModelObjectBuilder {
		EquityCorporateEvents.EquityCorporateEventsBuilder setShareForShare(ShareExtraordinaryEventEnum shareForShare);
		EquityCorporateEvents.EquityCorporateEventsBuilder setShareForOther(ShareExtraordinaryEventEnum shareForOther);
		EquityCorporateEvents.EquityCorporateEventsBuilder setShareForCombined(ShareExtraordinaryEventEnum shareForCombined);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("shareForShare"), ShareExtraordinaryEventEnum.class, getShareForShare(), this);
			processor.processBasic(path.newSubPath("shareForOther"), ShareExtraordinaryEventEnum.class, getShareForOther(), this);
			processor.processBasic(path.newSubPath("shareForCombined"), ShareExtraordinaryEventEnum.class, getShareForCombined(), this);
		}
		

		EquityCorporateEvents.EquityCorporateEventsBuilder prune();
	}

	/*********************** Immutable Implementation of EquityCorporateEvents  ***********************/
	class EquityCorporateEventsImpl implements EquityCorporateEvents {
		private final ShareExtraordinaryEventEnum shareForShare;
		private final ShareExtraordinaryEventEnum shareForOther;
		private final ShareExtraordinaryEventEnum shareForCombined;
		
		protected EquityCorporateEventsImpl(EquityCorporateEvents.EquityCorporateEventsBuilder builder) {
			this.shareForShare = builder.getShareForShare();
			this.shareForOther = builder.getShareForOther();
			this.shareForCombined = builder.getShareForCombined();
		}
		
		@Override
		@RosettaAttribute("shareForShare")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shareForShare")
		public ShareExtraordinaryEventEnum getShareForShare() {
			return shareForShare;
		}
		
		@Override
		@RosettaAttribute("shareForOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shareForOther")
		public ShareExtraordinaryEventEnum getShareForOther() {
			return shareForOther;
		}
		
		@Override
		@RosettaAttribute("shareForCombined")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shareForCombined")
		public ShareExtraordinaryEventEnum getShareForCombined() {
			return shareForCombined;
		}
		
		@Override
		public EquityCorporateEvents build() {
			return this;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder toBuilder() {
			EquityCorporateEvents.EquityCorporateEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityCorporateEvents.EquityCorporateEventsBuilder builder) {
			ofNullable(getShareForShare()).ifPresent(builder::setShareForShare);
			ofNullable(getShareForOther()).ifPresent(builder::setShareForOther);
			ofNullable(getShareForCombined()).ifPresent(builder::setShareForCombined);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityCorporateEvents _that = getType().cast(o);
		
			if (!Objects.equals(shareForShare, _that.getShareForShare())) return false;
			if (!Objects.equals(shareForOther, _that.getShareForOther())) return false;
			if (!Objects.equals(shareForCombined, _that.getShareForCombined())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (shareForShare != null ? shareForShare.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForOther != null ? shareForOther.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForCombined != null ? shareForCombined.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityCorporateEvents {" +
				"shareForShare=" + this.shareForShare + ", " +
				"shareForOther=" + this.shareForOther + ", " +
				"shareForCombined=" + this.shareForCombined +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityCorporateEvents  ***********************/
	class EquityCorporateEventsBuilderImpl implements EquityCorporateEvents.EquityCorporateEventsBuilder {
	
		protected ShareExtraordinaryEventEnum shareForShare;
		protected ShareExtraordinaryEventEnum shareForOther;
		protected ShareExtraordinaryEventEnum shareForCombined;
		
		@Override
		@RosettaAttribute("shareForShare")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shareForShare")
		public ShareExtraordinaryEventEnum getShareForShare() {
			return shareForShare;
		}
		
		@Override
		@RosettaAttribute("shareForOther")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shareForOther")
		public ShareExtraordinaryEventEnum getShareForOther() {
			return shareForOther;
		}
		
		@Override
		@RosettaAttribute("shareForCombined")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shareForCombined")
		public ShareExtraordinaryEventEnum getShareForCombined() {
			return shareForCombined;
		}
		
		@RosettaAttribute("shareForShare")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shareForShare")
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder setShareForShare(ShareExtraordinaryEventEnum _shareForShare) {
			this.shareForShare = _shareForShare == null ? null : _shareForShare;
			return this;
		}
		
		@RosettaAttribute("shareForOther")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shareForOther")
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder setShareForOther(ShareExtraordinaryEventEnum _shareForOther) {
			this.shareForOther = _shareForOther == null ? null : _shareForOther;
			return this;
		}
		
		@RosettaAttribute("shareForCombined")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shareForCombined")
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder setShareForCombined(ShareExtraordinaryEventEnum _shareForCombined) {
			this.shareForCombined = _shareForCombined == null ? null : _shareForCombined;
			return this;
		}
		
		@Override
		public EquityCorporateEvents build() {
			return new EquityCorporateEvents.EquityCorporateEventsImpl(this);
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getShareForShare()!=null) return true;
			if (getShareForOther()!=null) return true;
			if (getShareForCombined()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityCorporateEvents.EquityCorporateEventsBuilder o = (EquityCorporateEvents.EquityCorporateEventsBuilder) other;
			
			
			merger.mergeBasic(getShareForShare(), o.getShareForShare(), this::setShareForShare);
			merger.mergeBasic(getShareForOther(), o.getShareForOther(), this::setShareForOther);
			merger.mergeBasic(getShareForCombined(), o.getShareForCombined(), this::setShareForCombined);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityCorporateEvents _that = getType().cast(o);
		
			if (!Objects.equals(shareForShare, _that.getShareForShare())) return false;
			if (!Objects.equals(shareForOther, _that.getShareForOther())) return false;
			if (!Objects.equals(shareForCombined, _that.getShareForCombined())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (shareForShare != null ? shareForShare.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForOther != null ? shareForOther.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForCombined != null ? shareForCombined.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityCorporateEventsBuilder {" +
				"shareForShare=" + this.shareForShare + ", " +
				"shareForOther=" + this.shareForOther + ", " +
				"shareForCombined=" + this.shareForCombined +
			'}';
		}
	}
}
