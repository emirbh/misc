package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.TradeConfirmation2Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies time and type of contract confirmation.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeConfirmation2", builder=TradeConfirmation2.TradeConfirmation2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeConfirmation2", model="iso20022", builder=TradeConfirmation2.TradeConfirmation2BuilderImpl.class, version="${project.version}")
public interface TradeConfirmation2 extends RosettaModelObject {

	TradeConfirmation2Meta metaData = new TradeConfirmation2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the contract was confirmed electronically or non-electronically.
	 */
	TradeConfirmationType1Code getTp();
	/**
	 * Date and time of the trade confirmation, indicating time zone in which the confirmation has taken place.
	 */
	ZonedDateTime getTmStmp();

	/*********************** Build Methods  ***********************/
	TradeConfirmation2 build();
	
	TradeConfirmation2.TradeConfirmation2Builder toBuilder();
	
	static TradeConfirmation2.TradeConfirmation2Builder builder() {
		return new TradeConfirmation2.TradeConfirmation2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeConfirmation2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeConfirmation2> getType() {
		return TradeConfirmation2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), TradeConfirmationType1Code.class, getTp(), this);
		processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeConfirmation2Builder extends TradeConfirmation2, RosettaModelObjectBuilder {
		TradeConfirmation2.TradeConfirmation2Builder setTp(TradeConfirmationType1Code tp);
		TradeConfirmation2.TradeConfirmation2Builder setTmStmp(ZonedDateTime tmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), TradeConfirmationType1Code.class, getTp(), this);
			processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
		}
		

		TradeConfirmation2.TradeConfirmation2Builder prune();
	}

	/*********************** Immutable Implementation of TradeConfirmation2  ***********************/
	class TradeConfirmation2Impl implements TradeConfirmation2 {
		private final TradeConfirmationType1Code tp;
		private final ZonedDateTime tmStmp;
		
		protected TradeConfirmation2Impl(TradeConfirmation2.TradeConfirmation2Builder builder) {
			this.tp = builder.getTp();
			this.tmStmp = builder.getTmStmp();
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public TradeConfirmationType1Code getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@Override
		public TradeConfirmation2 build() {
			return this;
		}
		
		@Override
		public TradeConfirmation2.TradeConfirmation2Builder toBuilder() {
			TradeConfirmation2.TradeConfirmation2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeConfirmation2.TradeConfirmation2Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
			ofNullable(getTmStmp()).ifPresent(builder::setTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation2 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation2 {" +
				"tp=" + this.tp + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeConfirmation2  ***********************/
	class TradeConfirmation2BuilderImpl implements TradeConfirmation2.TradeConfirmation2Builder {
	
		protected TradeConfirmationType1Code tp;
		protected ZonedDateTime tmStmp;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public TradeConfirmationType1Code getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public TradeConfirmation2.TradeConfirmation2Builder setTp(TradeConfirmationType1Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tmStmp")
		@Override
		public TradeConfirmation2.TradeConfirmation2Builder setTmStmp(ZonedDateTime _tmStmp) {
			this.tmStmp = _tmStmp == null ? null : _tmStmp;
			return this;
		}
		
		@Override
		public TradeConfirmation2 build() {
			return new TradeConfirmation2.TradeConfirmation2Impl(this);
		}
		
		@Override
		public TradeConfirmation2.TradeConfirmation2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation2.TradeConfirmation2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			if (getTmStmp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation2.TradeConfirmation2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeConfirmation2.TradeConfirmation2Builder o = (TradeConfirmation2.TradeConfirmation2Builder) other;
			
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			merger.mergeBasic(getTmStmp(), o.getTmStmp(), this::setTmStmp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation2 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation2Builder {" +
				"tp=" + this.tp + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}
}
