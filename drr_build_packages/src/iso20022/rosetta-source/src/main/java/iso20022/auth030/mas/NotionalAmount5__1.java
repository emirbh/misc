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
import iso20022.auth030.mas.meta.NotionalAmount5__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalAmount5__1", builder=NotionalAmount5__1.NotionalAmount5__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NotionalAmount5__1", model="iso20022", builder=NotionalAmount5__1.NotionalAmount5__1BuilderImpl.class, version="${project.version}")
public interface NotionalAmount5__1 extends RosettaModelObject {

	NotionalAmount5__1Meta metaData = new NotionalAmount5__1Meta();

	/*********************** Getter Methods  ***********************/
	AmountAndDirection106__2 getAmt();

	/*********************** Build Methods  ***********************/
	NotionalAmount5__1 build();
	
	NotionalAmount5__1.NotionalAmount5__1Builder toBuilder();
	
	static NotionalAmount5__1.NotionalAmount5__1Builder builder() {
		return new NotionalAmount5__1.NotionalAmount5__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalAmount5__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalAmount5__1> getType() {
		return NotionalAmount5__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amt"), processor, AmountAndDirection106__2.class, getAmt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalAmount5__1Builder extends NotionalAmount5__1, RosettaModelObjectBuilder {
		AmountAndDirection106__2.AmountAndDirection106__2Builder getOrCreateAmt();
		@Override
		AmountAndDirection106__2.AmountAndDirection106__2Builder getAmt();
		NotionalAmount5__1.NotionalAmount5__1Builder setAmt(AmountAndDirection106__2 amt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amt"), processor, AmountAndDirection106__2.AmountAndDirection106__2Builder.class, getAmt());
		}
		

		NotionalAmount5__1.NotionalAmount5__1Builder prune();
	}

	/*********************** Immutable Implementation of NotionalAmount5__1  ***********************/
	class NotionalAmount5__1Impl implements NotionalAmount5__1 {
		private final AmountAndDirection106__2 amt;
		
		protected NotionalAmount5__1Impl(NotionalAmount5__1.NotionalAmount5__1Builder builder) {
			this.amt = ofNullable(builder.getAmt()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public AmountAndDirection106__2 getAmt() {
			return amt;
		}
		
		@Override
		public NotionalAmount5__1 build() {
			return this;
		}
		
		@Override
		public NotionalAmount5__1.NotionalAmount5__1Builder toBuilder() {
			NotionalAmount5__1.NotionalAmount5__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalAmount5__1.NotionalAmount5__1Builder builder) {
			ofNullable(getAmt()).ifPresent(builder::setAmt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalAmount5__1 _that = getType().cast(o);
		
			if (!Objects.equals(amt, _that.getAmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalAmount5__1 {" +
				"amt=" + this.amt +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalAmount5__1  ***********************/
	class NotionalAmount5__1BuilderImpl implements NotionalAmount5__1.NotionalAmount5__1Builder {
	
		protected AmountAndDirection106__2.AmountAndDirection106__2Builder amt;
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public AmountAndDirection106__2.AmountAndDirection106__2Builder getAmt() {
			return amt;
		}
		
		@Override
		public AmountAndDirection106__2.AmountAndDirection106__2Builder getOrCreateAmt() {
			AmountAndDirection106__2.AmountAndDirection106__2Builder result;
			if (amt!=null) {
				result = amt;
			}
			else {
				result = amt = AmountAndDirection106__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amt")
		@Override
		public NotionalAmount5__1.NotionalAmount5__1Builder setAmt(AmountAndDirection106__2 _amt) {
			this.amt = _amt == null ? null : _amt.toBuilder();
			return this;
		}
		
		@Override
		public NotionalAmount5__1 build() {
			return new NotionalAmount5__1.NotionalAmount5__1Impl(this);
		}
		
		@Override
		public NotionalAmount5__1.NotionalAmount5__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmount5__1.NotionalAmount5__1Builder prune() {
			if (amt!=null && !amt.prune().hasData()) amt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmt()!=null && getAmt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmount5__1.NotionalAmount5__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalAmount5__1.NotionalAmount5__1Builder o = (NotionalAmount5__1.NotionalAmount5__1Builder) other;
			
			merger.mergeRosetta(getAmt(), o.getAmt(), this::setAmt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalAmount5__1 _that = getType().cast(o);
		
			if (!Objects.equals(amt, _that.getAmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalAmount5__1Builder {" +
				"amt=" + this.amt +
			'}';
		}
	}
}
