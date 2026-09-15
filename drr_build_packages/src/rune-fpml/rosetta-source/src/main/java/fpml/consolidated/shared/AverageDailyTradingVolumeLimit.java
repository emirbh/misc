package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.AverageDailyTradingVolumeLimitMeta;
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
 * Provision To indicate the limitation percentage and limitation period.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision To indicate the limitation percentage and limitation period.
 *
 */
@RosettaDataType(value="AverageDailyTradingVolumeLimit", builder=AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AverageDailyTradingVolumeLimit", model="fpml", builder=AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilderImpl.class, version="2.1.1")
public interface AverageDailyTradingVolumeLimit extends RosettaModelObject {

	AverageDailyTradingVolumeLimitMeta metaData = new AverageDailyTradingVolumeLimitMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the limitation percentage in Average Daily trading volume. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the limitation percentage in Average Daily trading volume. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getLimitationPercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the limitation period for Average Daily trading volume in number of days.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the limitation period for Average Daily trading volume in number of days.
	 *
	 */
	Integer getLimitationPeriod();

	/*********************** Build Methods  ***********************/
	AverageDailyTradingVolumeLimit build();
	
	AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder toBuilder();
	
	static AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder builder() {
		return new AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AverageDailyTradingVolumeLimit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AverageDailyTradingVolumeLimit> getType() {
		return AverageDailyTradingVolumeLimit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("limitationPercentage"), BigDecimal.class, getLimitationPercentage(), this);
		processor.processBasic(path.newSubPath("limitationPeriod"), Integer.class, getLimitationPeriod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AverageDailyTradingVolumeLimitBuilder extends AverageDailyTradingVolumeLimit, RosettaModelObjectBuilder {
		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder setLimitationPercentage(BigDecimal limitationPercentage);
		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder setLimitationPeriod(Integer limitationPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("limitationPercentage"), BigDecimal.class, getLimitationPercentage(), this);
			processor.processBasic(path.newSubPath("limitationPeriod"), Integer.class, getLimitationPeriod(), this);
		}
		

		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder prune();
	}

	/*********************** Immutable Implementation of AverageDailyTradingVolumeLimit  ***********************/
	class AverageDailyTradingVolumeLimitImpl implements AverageDailyTradingVolumeLimit {
		private final BigDecimal limitationPercentage;
		private final Integer limitationPeriod;
		
		protected AverageDailyTradingVolumeLimitImpl(AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder builder) {
			this.limitationPercentage = builder.getLimitationPercentage();
			this.limitationPeriod = builder.getLimitationPeriod();
		}
		
		@Override
		@RosettaAttribute("limitationPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("limitationPercentage")
		public BigDecimal getLimitationPercentage() {
			return limitationPercentage;
		}
		
		@Override
		@RosettaAttribute("limitationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("limitationPeriod")
		public Integer getLimitationPeriod() {
			return limitationPeriod;
		}
		
		@Override
		public AverageDailyTradingVolumeLimit build() {
			return this;
		}
		
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder toBuilder() {
			AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder builder) {
			ofNullable(getLimitationPercentage()).ifPresent(builder::setLimitationPercentage);
			ofNullable(getLimitationPeriod()).ifPresent(builder::setLimitationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AverageDailyTradingVolumeLimit _that = getType().cast(o);
		
			if (!Objects.equals(limitationPercentage, _that.getLimitationPercentage())) return false;
			if (!Objects.equals(limitationPeriod, _that.getLimitationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitationPercentage != null ? limitationPercentage.hashCode() : 0);
			_result = 31 * _result + (limitationPeriod != null ? limitationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AverageDailyTradingVolumeLimit {" +
				"limitationPercentage=" + this.limitationPercentage + ", " +
				"limitationPeriod=" + this.limitationPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of AverageDailyTradingVolumeLimit  ***********************/
	class AverageDailyTradingVolumeLimitBuilderImpl implements AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder {
	
		protected BigDecimal limitationPercentage;
		protected Integer limitationPeriod;
		
		@Override
		@RosettaAttribute("limitationPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("limitationPercentage")
		public BigDecimal getLimitationPercentage() {
			return limitationPercentage;
		}
		
		@Override
		@RosettaAttribute("limitationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("limitationPeriod")
		public Integer getLimitationPeriod() {
			return limitationPeriod;
		}
		
		@RosettaAttribute("limitationPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("limitationPercentage")
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder setLimitationPercentage(BigDecimal _limitationPercentage) {
			this.limitationPercentage = _limitationPercentage == null ? null : _limitationPercentage;
			return this;
		}
		
		@RosettaAttribute("limitationPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("limitationPeriod")
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder setLimitationPeriod(Integer _limitationPeriod) {
			this.limitationPeriod = _limitationPeriod == null ? null : _limitationPeriod;
			return this;
		}
		
		@Override
		public AverageDailyTradingVolumeLimit build() {
			return new AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitImpl(this);
		}
		
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLimitationPercentage()!=null) return true;
			if (getLimitationPeriod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder o = (AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder) other;
			
			
			merger.mergeBasic(getLimitationPercentage(), o.getLimitationPercentage(), this::setLimitationPercentage);
			merger.mergeBasic(getLimitationPeriod(), o.getLimitationPeriod(), this::setLimitationPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AverageDailyTradingVolumeLimit _that = getType().cast(o);
		
			if (!Objects.equals(limitationPercentage, _that.getLimitationPercentage())) return false;
			if (!Objects.equals(limitationPeriod, _that.getLimitationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitationPercentage != null ? limitationPercentage.hashCode() : 0);
			_result = 31 * _result + (limitationPeriod != null ? limitationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AverageDailyTradingVolumeLimitBuilder {" +
				"limitationPercentage=" + this.limitationPercentage + ", " +
				"limitationPeriod=" + this.limitationPeriod +
			'}';
		}
	}
}
