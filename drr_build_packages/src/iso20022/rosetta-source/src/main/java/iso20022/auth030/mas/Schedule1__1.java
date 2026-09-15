package iso20022.auth030.mas;

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
import com.rosetta.model.lib.records.Date;
import iso20022.auth030.mas.meta.Schedule1__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Schedule1__1", builder=Schedule1__1.Schedule1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Schedule1__1", model="iso20022", builder=Schedule1__1.Schedule1__1BuilderImpl.class, version="${project.version}")
public interface Schedule1__1 extends RosettaModelObject {

	Schedule1__1Meta metaData = new Schedule1__1Meta();

	/*********************** Getter Methods  ***********************/
	Date getUadjstdFctvDt();
	Date getUadjstdEndDt();
	SecuritiesTransactionPrice17Choice__1 getPric();

	/*********************** Build Methods  ***********************/
	Schedule1__1 build();
	
	Schedule1__1.Schedule1__1Builder toBuilder();
	
	static Schedule1__1.Schedule1__1Builder builder() {
		return new Schedule1__1.Schedule1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Schedule1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Schedule1__1> getType() {
		return Schedule1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("uadjstdFctvDt"), Date.class, getUadjstdFctvDt(), this);
		processor.processBasic(path.newSubPath("uadjstdEndDt"), Date.class, getUadjstdEndDt(), this);
		processRosetta(path.newSubPath("pric"), processor, SecuritiesTransactionPrice17Choice__1.class, getPric());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Schedule1__1Builder extends Schedule1__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreatePric();
		@Override
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getPric();
		Schedule1__1.Schedule1__1Builder setUadjstdFctvDt(Date uadjstdFctvDt);
		Schedule1__1.Schedule1__1Builder setUadjstdEndDt(Date uadjstdEndDt);
		Schedule1__1.Schedule1__1Builder setPric(SecuritiesTransactionPrice17Choice__1 pric);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("uadjstdFctvDt"), Date.class, getUadjstdFctvDt(), this);
			processor.processBasic(path.newSubPath("uadjstdEndDt"), Date.class, getUadjstdEndDt(), this);
			processRosetta(path.newSubPath("pric"), processor, SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder.class, getPric());
		}
		

		Schedule1__1.Schedule1__1Builder prune();
	}

	/*********************** Immutable Implementation of Schedule1__1  ***********************/
	class Schedule1__1Impl implements Schedule1__1 {
		private final Date uadjstdFctvDt;
		private final Date uadjstdEndDt;
		private final SecuritiesTransactionPrice17Choice__1 pric;
		
		protected Schedule1__1Impl(Schedule1__1.Schedule1__1Builder builder) {
			this.uadjstdFctvDt = builder.getUadjstdFctvDt();
			this.uadjstdEndDt = builder.getUadjstdEndDt();
			this.pric = ofNullable(builder.getPric()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		public Date getUadjstdFctvDt() {
			return uadjstdFctvDt;
		}
		
		@Override
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uadjstdEndDt")
		public Date getUadjstdEndDt() {
			return uadjstdEndDt;
		}
		
		@Override
		@RosettaAttribute("pric")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pric")
		public SecuritiesTransactionPrice17Choice__1 getPric() {
			return pric;
		}
		
		@Override
		public Schedule1__1 build() {
			return this;
		}
		
		@Override
		public Schedule1__1.Schedule1__1Builder toBuilder() {
			Schedule1__1.Schedule1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Schedule1__1.Schedule1__1Builder builder) {
			ofNullable(getUadjstdFctvDt()).ifPresent(builder::setUadjstdFctvDt);
			ofNullable(getUadjstdEndDt()).ifPresent(builder::setUadjstdEndDt);
			ofNullable(getPric()).ifPresent(builder::setPric);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule1__1 _that = getType().cast(o);
		
			if (!Objects.equals(uadjstdFctvDt, _that.getUadjstdFctvDt())) return false;
			if (!Objects.equals(uadjstdEndDt, _that.getUadjstdEndDt())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uadjstdFctvDt != null ? uadjstdFctvDt.hashCode() : 0);
			_result = 31 * _result + (uadjstdEndDt != null ? uadjstdEndDt.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedule1__1 {" +
				"uadjstdFctvDt=" + this.uadjstdFctvDt + ", " +
				"uadjstdEndDt=" + this.uadjstdEndDt + ", " +
				"pric=" + this.pric +
			'}';
		}
	}

	/*********************** Builder Implementation of Schedule1__1  ***********************/
	class Schedule1__1BuilderImpl implements Schedule1__1.Schedule1__1Builder {
	
		protected Date uadjstdFctvDt;
		protected Date uadjstdEndDt;
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder pric;
		
		@Override
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		public Date getUadjstdFctvDt() {
			return uadjstdFctvDt;
		}
		
		@Override
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uadjstdEndDt")
		public Date getUadjstdEndDt() {
			return uadjstdEndDt;
		}
		
		@Override
		@RosettaAttribute("pric")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pric")
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getPric() {
			return pric;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreatePric() {
			SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder result;
			if (pric!=null) {
				result = pric;
			}
			else {
				result = pric = SecuritiesTransactionPrice17Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("uadjstdFctvDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("uadjstdFctvDt")
		@Override
		public Schedule1__1.Schedule1__1Builder setUadjstdFctvDt(Date _uadjstdFctvDt) {
			this.uadjstdFctvDt = _uadjstdFctvDt == null ? null : _uadjstdFctvDt;
			return this;
		}
		
		@RosettaAttribute("uadjstdEndDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uadjstdEndDt")
		@Override
		public Schedule1__1.Schedule1__1Builder setUadjstdEndDt(Date _uadjstdEndDt) {
			this.uadjstdEndDt = _uadjstdEndDt == null ? null : _uadjstdEndDt;
			return this;
		}
		
		@RosettaAttribute("pric")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pric")
		@Override
		public Schedule1__1.Schedule1__1Builder setPric(SecuritiesTransactionPrice17Choice__1 _pric) {
			this.pric = _pric == null ? null : _pric.toBuilder();
			return this;
		}
		
		@Override
		public Schedule1__1 build() {
			return new Schedule1__1.Schedule1__1Impl(this);
		}
		
		@Override
		public Schedule1__1.Schedule1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule1__1.Schedule1__1Builder prune() {
			if (pric!=null && !pric.prune().hasData()) pric = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUadjstdFctvDt()!=null) return true;
			if (getUadjstdEndDt()!=null) return true;
			if (getPric()!=null && getPric().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Schedule1__1.Schedule1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Schedule1__1.Schedule1__1Builder o = (Schedule1__1.Schedule1__1Builder) other;
			
			merger.mergeRosetta(getPric(), o.getPric(), this::setPric);
			
			merger.mergeBasic(getUadjstdFctvDt(), o.getUadjstdFctvDt(), this::setUadjstdFctvDt);
			merger.mergeBasic(getUadjstdEndDt(), o.getUadjstdEndDt(), this::setUadjstdEndDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Schedule1__1 _that = getType().cast(o);
		
			if (!Objects.equals(uadjstdFctvDt, _that.getUadjstdFctvDt())) return false;
			if (!Objects.equals(uadjstdEndDt, _that.getUadjstdEndDt())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uadjstdFctvDt != null ? uadjstdFctvDt.hashCode() : 0);
			_result = 31 * _result + (uadjstdEndDt != null ? uadjstdEndDt.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Schedule1__1Builder {" +
				"uadjstdFctvDt=" + this.uadjstdFctvDt + ", " +
				"uadjstdEndDt=" + this.uadjstdEndDt + ", " +
				"pric=" + this.pric +
			'}';
		}
	}
}
