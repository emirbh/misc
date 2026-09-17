package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.BespokeTransferTimingMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify any bespoke Transfer Timing language by each party to the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="BespokeTransferTiming", builder=BespokeTransferTiming.BespokeTransferTimingBuilderImpl.class, version="6.23.0")
@RuneDataType(value="BespokeTransferTiming", model="cdm", builder=BespokeTransferTiming.BespokeTransferTimingBuilderImpl.class, version="6.23.0")
public interface BespokeTransferTiming extends RosettaModelObject {

	BespokeTransferTimingMeta metaData = new BespokeTransferTimingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A boolean flag to specify whether bespoke transfer terms are applicable or not.
	 */
	Boolean getIsApplicable();
	/**
	 * The bespoke transfer timing terms applicable to the agreement.
	 */
	String getBespokeTransferTimingTerms();

	/*********************** Build Methods  ***********************/
	BespokeTransferTiming build();
	
	BespokeTransferTiming.BespokeTransferTimingBuilder toBuilder();
	
	static BespokeTransferTiming.BespokeTransferTimingBuilder builder() {
		return new BespokeTransferTiming.BespokeTransferTimingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BespokeTransferTiming> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BespokeTransferTiming> getType() {
		return BespokeTransferTiming.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("bespokeTransferTimingTerms"), String.class, getBespokeTransferTimingTerms(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BespokeTransferTimingBuilder extends BespokeTransferTiming, RosettaModelObjectBuilder {
		BespokeTransferTiming.BespokeTransferTimingBuilder setIsApplicable(Boolean isApplicable);
		BespokeTransferTiming.BespokeTransferTimingBuilder setBespokeTransferTimingTerms(String bespokeTransferTimingTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("bespokeTransferTimingTerms"), String.class, getBespokeTransferTimingTerms(), this);
		}
		

		BespokeTransferTiming.BespokeTransferTimingBuilder prune();
	}

	/*********************** Immutable Implementation of BespokeTransferTiming  ***********************/
	class BespokeTransferTimingImpl implements BespokeTransferTiming {
		private final Boolean isApplicable;
		private final String bespokeTransferTimingTerms;
		
		protected BespokeTransferTimingImpl(BespokeTransferTiming.BespokeTransferTimingBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.bespokeTransferTimingTerms = builder.getBespokeTransferTimingTerms();
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("bespokeTransferTimingTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeTransferTimingTerms")
		public String getBespokeTransferTimingTerms() {
			return bespokeTransferTimingTerms;
		}
		
		@Override
		public BespokeTransferTiming build() {
			return this;
		}
		
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder toBuilder() {
			BespokeTransferTiming.BespokeTransferTimingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BespokeTransferTiming.BespokeTransferTimingBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getBespokeTransferTimingTerms()).ifPresent(builder::setBespokeTransferTimingTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeTransferTiming _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(bespokeTransferTimingTerms, _that.getBespokeTransferTimingTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (bespokeTransferTimingTerms != null ? bespokeTransferTimingTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeTransferTiming {" +
				"isApplicable=" + this.isApplicable + ", " +
				"bespokeTransferTimingTerms=" + this.bespokeTransferTimingTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of BespokeTransferTiming  ***********************/
	class BespokeTransferTimingBuilderImpl implements BespokeTransferTiming.BespokeTransferTimingBuilder {
	
		protected Boolean isApplicable;
		protected String bespokeTransferTimingTerms;
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("bespokeTransferTimingTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeTransferTimingTerms")
		public String getBespokeTransferTimingTerms() {
			return bespokeTransferTimingTerms;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("bespokeTransferTimingTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bespokeTransferTimingTerms")
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder setBespokeTransferTimingTerms(String _bespokeTransferTimingTerms) {
			this.bespokeTransferTimingTerms = _bespokeTransferTimingTerms == null ? null : _bespokeTransferTimingTerms;
			return this;
		}
		
		@Override
		public BespokeTransferTiming build() {
			return new BespokeTransferTiming.BespokeTransferTimingImpl(this);
		}
		
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getBespokeTransferTimingTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeTransferTiming.BespokeTransferTimingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BespokeTransferTiming.BespokeTransferTimingBuilder o = (BespokeTransferTiming.BespokeTransferTimingBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getBespokeTransferTimingTerms(), o.getBespokeTransferTimingTerms(), this::setBespokeTransferTimingTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeTransferTiming _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(bespokeTransferTimingTerms, _that.getBespokeTransferTimingTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (bespokeTransferTimingTerms != null ? bespokeTransferTimingTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeTransferTimingBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"bespokeTransferTimingTerms=" + this.bespokeTransferTimingTerms +
			'}';
		}
	}
}
